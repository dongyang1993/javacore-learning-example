package org.core.jdk11;

import java.util.HashMap;
import java.util.Map;

public enum HttpStatus {
    OK(200, "OK"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final Integer code;
    private final String desc;

    HttpStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, HttpStatus> map = new HashMap<>();

    static {
        for (HttpStatus value : values()) {
            map.put(value.code, value);
        }
    }
}
