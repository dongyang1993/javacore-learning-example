package org.core.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenericJackson2JsonRedisSerializer {
    private final ObjectMapper mapper = new ObjectMapper();
    private static final byte[] EMPTY_ARRAY = new byte[0];

    {
        /**
         * 启用默认类型,将类信息写入@class属性
         * LaissezFaireSubTypeValidator.instance 放任所有类型的校验器----默认的校验器
         * mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.PROPERTY); ----没有其他要自定义的话，这一行配置就够用
         */
        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.EVERYTHING, JsonTypeInfo.As.PROPERTY);

/*        //定义序列化范围和校验器
        ObjectMapper.DefaultTypeResolverBuilder typeResolverBuilder = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.EVERYTHING, this.mapper.getPolymorphicTypeValidator());
        //设置class属性名称
        typeResolverBuilder.init(JsonTypeInfo.Id.CLASS, null);
        //作为一个属性
        typeResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);

        mapper.setDefaultTyping(typeResolverBuilder);*/

/*        // 允许私有字段序列化
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);*/

        //自定义时间类型序列化和反序列化格式
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mapper.registerModule(javaTimeModule);
    }

    public byte[] serialize(Object obj) {
        if (obj == null) {
            return EMPTY_ARRAY;
        } else {
            try {
                return mapper.writeValueAsBytes(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try {
            return mapper.readValue(bytes, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        } else {
            try {
                return (T) mapper.readValue(bytes, Object.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
