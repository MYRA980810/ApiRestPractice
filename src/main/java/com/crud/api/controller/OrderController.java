package com.crud.api.controller;

// TODO 1: Anotar con @RestController y @RequestMapping("/api/orders")

// TODO 2: Inyectar OrderService

// TODO 3: POST /api/orders -> Crear orden (requiere autenticación):
//   @PostMapping
//   public ResponseEntity<ApiResponse<OrderResponse>> create(
//       @Valid @RequestBody OrderRequest request,
//       @AuthenticationPrincipal UserDetails userDetails)  // Obtener usuario del token JWT
//   - Llamar a orderService.createOrder(request, userDetails.getUsername())
//   - @AuthenticationPrincipal inyecta el UserDetails del SecurityContext (puesto por JwtAuthenticationFilter)
//   - userDetails.getUsername() devuelve el email (así lo configuramos en User)
//   - Retornar HttpStatus.CREATED

// TODO 4: GET /api/orders -> Listar órdenes del usuario autenticado:
//   @GetMapping
//   public ResponseEntity<ApiResponse<List<OrderResponse>>> findMyOrders(
//       @AuthenticationPrincipal UserDetails userDetails)
//   - Cada usuario solo ve SUS órdenes

// TODO 5: GET /api/orders/{id} -> Obtener orden por ID:
//   @GetMapping("/{id}")
//   public ResponseEntity<ApiResponse<OrderResponse>> findById(@PathVariable Long id)
//   - Considerar: verificar que la orden pertenece al usuario autenticado (o es ADMIN)

// TODO 6: PUT /api/orders/{id}/cancel -> Cancelar orden:
//   @PutMapping("/{id}/cancel")
//   public ResponseEntity<ApiResponse<OrderResponse>> cancel(
//       @PathVariable Long id,
//       @AuthenticationPrincipal UserDetails userDetails)

// TODO 7 (Opcional): GET /api/admin/orders -> Listar TODAS las órdenes (solo ADMIN):
//   Podría ir en un AdminController separado con @PreAuthorize("hasRole('ADMIN')")

public class OrderController {
}
