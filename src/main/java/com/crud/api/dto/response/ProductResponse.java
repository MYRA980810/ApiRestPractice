package com.crud.api.dto.response;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos:
//   - private Long id;
//   - private String name;
//   - private String description;
//   - private BigDecimal price;
//   - private Integer stock;
//   - private Boolean active;
//   - private String categoryName;  // Solo el nombre, NO el objeto Category completo
//   - private Long categoryId;

// NOTA: Se mapea categoryName desde product.getCategory().getName() en el mapper
// Así el cliente recibe datos planos sin relaciones anidadas complejas

public class ProductResponse {
}
