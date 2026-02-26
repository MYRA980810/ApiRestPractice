package com.crud.api.entity;

import java.util.Arrays;

import com.crud.api.exception.InvalidEnumValueException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String code;
    
    
    Role(String code) {
        this.code = code;
    }
    
    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static Role fromCode(String code) {
        return Arrays.stream(values())
                .filter(role -> role.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new InvalidEnumValueException(Role.class, code));
    }
}
