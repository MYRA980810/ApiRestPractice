package com.crud.api.dto.response;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos (solo lo que se quiere exponer, NO la entidad completa):
//   - private Long id;
//   - private String name;
//   - private String description;
//   - private int productCount;   // Solo el conteo, NO la lista de productos
//     -> Esto evita exponer datos innecesarios y previene recursión en serialización

// NOTA: Nunca exponer las entities directamente en los endpoints.
// Los DTOs de response permiten controlar exactamente qué datos ve el cliente.

public class CategoryResponse {
}
