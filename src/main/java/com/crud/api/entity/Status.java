package com.crud.api.entity;

import java.util.Arrays;

import com.crud.api.exception.InvalidEnumValueException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

   PENDING("Pending"),
   CONFIRMED("Confirmed"),
   CANCEL("Cancel");

   private final String code;

   Status(String code){
    this.code = code;
   }

   @JsonValue
   public String getCode(){
    return code;
   }

   @JsonCreator
   public static Status fromCode(String code){
    return Arrays.stream(values())
    .filter(status -> status.code.equals(code))
    .findFirst()
    .orElseThrow(() -> new InvalidEnumValueException(Status.class, code));
   }

}
