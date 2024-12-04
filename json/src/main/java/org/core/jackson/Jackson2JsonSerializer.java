package org.core.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class Jackson2JsonSerializer {
    private final ObjectMapper mapper = new ObjectMapper();

    {
        // 启用默认类型,将类信息写入@class属性
        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        // 允许私有字段序列化
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        mapper.registerModule(new JavaTimeModule());
    }

    public byte[] serialize(Object obj) {
        if (obj == null) {
            return new byte[0];
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
