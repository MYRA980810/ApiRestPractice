package com.crud.api.validation.annotation;

// TODO 1: Crear la anotación personalizada @ValidPrice
//   - @Target(ElementType.FIELD)
//   - @Retention(RetentionPolicy.RUNTIME)
//   - @Documented
//   - @Constraint(validatedBy = ValidPriceValidator.class)

// TODO 2: Definir los métodos obligatorios:
//   - String message() default "El precio debe ser mayor a 0 y tener máximo 2 decimales";
//   - Class<?>[] groups() default {};
//   - Class<? extends Payload>[] payload() default {};

// USO EN DTO:
//   @ValidPrice
//   private BigDecimal price;

// NOTA: Esta validación verifica:
//   1. Que el precio sea mayor a 0
//   2. Que tenga máximo 2 decimales (ej: 19.99 OK, 19.999 NO)

// public @interface ValidPrice {
// }
public @interface ValidPrice {
}
