package org.core.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.Arrays;

public final class JacksonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String toJsonWithout(Object obj, String... ignores) {
        return ((ObjectNode) mapper.valueToTree(obj)).without(Arrays.asList(ignores)).toString();
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T toObject(String json, TypeReference<T> reference) {
        try {
            return mapper.readValue(json, reference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T toObject(String json, JavaType javaType) {
        try {
            return mapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static TypeFactory getTypeFactory() {
        return mapper.getTypeFactory();
    }

    public static ObjectNode toJsonNode(String json) {
        try {
            return (ObjectNode) mapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ObjectNode toJsonNode(Object obj) {
        return mapper.valueToTree(obj);
    }

    public static ArrayNode toJsonNodeArray(String json) {
        try {
            return (ArrayNode) mapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ArrayNode toJsonNodeArray(Object obj) {
        return mapper.valueToTree(obj);
    }

    public static <T> T convertValue(Object obj, Class<T> clazz) {
        return mapper.convertValue(obj, clazz);
    }

    public static <T> T convertValue(Object obj, TypeReference<T> reference) {
        return mapper.convertValue(obj, reference);
    }

    public static <T> T convertValue(Object obj, JavaType javaType) {
        return mapper.convertValue(obj, javaType);
    }
}
