package com.crud.api.validation.annotation;

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
public @interface UniqueEmail {
}
