package com.crud.api.dto.request;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos con validaciones:
//   - @NotNull(message = "Los items de la orden son obligatorios")
//     @Size(min = 1, message = "La orden debe tener al menos un item")
//     @Valid  // <-- IMPORTANTE: @Valid en colecciones activa la validación de cada elemento interno
//     private List<OrderItemRequest> items;

// NOTA: No se pide userId porque se obtiene del token JWT (usuario autenticado)
// NOTA: @Valid en la lista activa las validaciones dentro de OrderItemRequest

public class OrderRequest {
}
