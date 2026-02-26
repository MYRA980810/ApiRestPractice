package com.crud.api.service;

// TODO 1: Anotar con @Service

// TODO 2: Inyectar:
//   - OrderRepository orderRepository
//   - ProductRepository productRepository
//   - UserRepository userRepository
//   - OrderMapper orderMapper
//   - OrderValidator orderValidator (el Validator de Spring)

// TODO 3: Implementar createOrder(OrderRequest request, String userEmail) -> OrderResponse:
//   - @Transactional
//   - Este es el método más complejo de todo el proyecto
//
//   Paso 1: Validar con OrderValidator (validaciones de negocio)
//     - BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(request, "orderRequest")
//     - orderValidator.validate(request, bindingResult)
//     - if (bindingResult.hasErrors()) -> lanzar BadRequestException con los mensajes de error
//
//   Paso 2: Buscar el usuario autenticado
//     - User user = userRepository.findByEmail(userEmail)
//       .orElseThrow(() -> new ResourceNotFoundException("User", "email", userEmail))
//
//   Paso 3: Crear la Order
//     - Order order = new Order()
//     - order.setUser(user)
//     - order.setStatus("PENDING")
//
//   Paso 4: Procesar cada OrderItemRequest
//     - Para cada item del request:
//       a. Buscar el Product por productId
//       b. Verificar stock suficiente (ya lo hizo el validator, pero doble check en transacción)
//       c. Descontar stock: product.setStock(product.getStock() - item.getQuantity())
//       d. Crear OrderItem: setProduct, setQuantity, setUnitPrice(product.getPrice())
//       e. Agregar al order: order.addItem(orderItem) (usa el helper method)
//
//   Paso 5: Calcular el total
//     - Sumar todos los subtotales (unitPrice * quantity) de cada item
//     - order.setTotal(total)
//
//   Paso 6: Guardar
//     - orderRepository.save(order) -> cascade guardará también los OrderItems
//
//   Paso 7: Retornar
//     - orderMapper.toResponse(savedOrder)

// TODO 4: Implementar findByUser(String userEmail) -> List<OrderResponse>:
//   - @Transactional(readOnly = true)
//   - Buscar usuario por email, luego buscar órdenes por userId

// TODO 5: Implementar findById(Long id) -> OrderResponse:
//   - @Transactional(readOnly = true)
//   - Buscar orden, lanzar ResourceNotFoundException si no existe

// TODO 6: Implementar cancelOrder(Long id, String userEmail) -> OrderResponse:
//   - @Transactional
//   - Verificar que la orden pertenece al usuario
//   - Verificar que el status sea PENDING (solo se pueden cancelar órdenes pendientes)
//   - Devolver stock de cada producto
//   - Cambiar status a CANCELLED

public class OrderService {
}
