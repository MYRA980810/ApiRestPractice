package com.crud.api.dto.request;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos con validaciones:
//   - @NotBlank(message = "El nombre del producto es obligatorio")
//     @Size(min = 2, max = 200)
//     private String name;
//
//   - private String description;
//
//   - @NotNull(message = "El precio es obligatorio")
//     @ValidPrice  // <-- Validación personalizada: debe ser > 0 y máximo 2 decimales
//     private BigDecimal price;
//
//   - @NotNull(message = "El stock es obligatorio")
//     @Min(value = 0, message = "El stock no puede ser negativo")
//     private Integer stock;
//
//   - @NotNull(message = "La categoría es obligatoria")
//     private Long categoryId;  // Se recibe el ID, no la entidad completa

// NOTA: @ValidPrice es una validación personalizada que se implementará en:
//   - validation/annotation/ValidPrice.java (la anotación)
//   - validation/validator/ValidPriceValidator.java (la lógica con ConstraintValidator)

public class ProductRequest {
}
