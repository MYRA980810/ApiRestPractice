package com.crud.api.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crud.api.validation.validator.UniqueEmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// TODO 1: Crear la anotación personalizada @UniqueEmail
//   - @Target(ElementType.FIELD) -> Se aplica sobre campos
//   - @Retention(RetentionPolicy.RUNTIME) -> Disponible en tiempo de ejecución
//   - @Documented
//   - @Constraint(validatedBy = UniqueEmailValidator.class) -> Vincula con el validador

// TODO 2: Definir los métodos obligatorios del contrato de Bean Validation:
//   - String message() default "El email ya está registrado";
//   - Class<?>[] groups() default {};
//   - Class<? extends Payload>[] payload() default {};

// USO EN DTO:
//   @UniqueEmail
//   private String email;

// FLUJO: Cuando Spring encuentra @Valid en el controller y el campo tiene @UniqueEmail,
// automáticamente ejecuta UniqueEmailValidator.isValid() para verificar en BD

// public @interface UniqueEmail {
// }

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "El email ya está registrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
