package com.crud.api.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crud.api.validation.validator.ValidPriceValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidPriceValidator.class)
public @interface ValidPrice {
    String message() default "El precio debe ser mayor a 0 y tener máximo 2 decimales";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
