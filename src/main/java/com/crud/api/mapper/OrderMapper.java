package com.crud.api.mapper;

// TODO 1: Anotar con @Component

// TODO 2: Implementar método toResponse(Order order) -> OrderResponse:
//   - Mapear: id, orderDate, status, total
//   - Mapear: userName <- order.getUser().getName()
//   - Mapear: items <- mapear cada OrderItem a OrderItemResponse (ver TODO 3)
//   - Este es el mapper más complejo porque involucra relaciones anidadas

// TODO 3: Implementar método toItemResponse(OrderItem item) -> OrderItemResponse:
//   - Mapear: id, quantity, unitPrice, subtotal
//   - Mapear: productName <- item.getProduct().getName()
//   - Mapear: productId <- item.getProduct().getId()

// TODO 4: Implementar método toResponseList(List<Order> orders) -> List<OrderResponse>

// NOTA: La conversión de OrderRequest a Order se hace en el servicio porque requiere:
//   1. Buscar el usuario autenticado
//   2. Buscar cada producto por ID
//   3. Verificar stock disponible
//   4. Calcular totales
// Toda esa lógica es de negocio, no de mapeo simple

public class OrderMapper {
}
