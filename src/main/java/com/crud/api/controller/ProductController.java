package com.crud.api.controller;

// TODO 1: Anotar con @RestController y @RequestMapping("/api/products")

// TODO 2: Inyectar ProductService

// TODO 3: GET /api/products -> Listar todos los productos (público):
//   @GetMapping
//   public ResponseEntity<ApiResponse<List<ProductResponse>>> findAll()

// TODO 4: GET /api/products/{id} -> Obtener producto por ID (público):
//   @GetMapping("/{id}")
//   public ResponseEntity<ApiResponse<ProductResponse>> findById(@PathVariable Long id)

// TODO 5: GET /api/products/category/{categoryId} -> Productos por categoría (público):
//   @GetMapping("/category/{categoryId}")
//   public ResponseEntity<ApiResponse<List<ProductResponse>>> findByCategory(@PathVariable Long categoryId)

// TODO 6: POST /api/products -> Crear producto (solo ADMIN):
//   @PostMapping
//   @PreAuthorize("hasRole('ADMIN')")
//   public ResponseEntity<ApiResponse<ProductResponse>> create(@Valid @RequestBody ProductRequest request)
//   - @Valid activa @NotBlank, @NotNull, @Min, @Size Y @ValidPrice (validación personalizada)
//   - Retornar HttpStatus.CREATED

// TODO 7: PUT /api/products/{id} -> Actualizar producto (solo ADMIN):
//   @PutMapping("/{id}")
//   @PreAuthorize("hasRole('ADMIN')")
//   public ResponseEntity<ApiResponse<ProductResponse>> update(@PathVariable Long id,
//                                                               @Valid @RequestBody ProductRequest request)

// TODO 8: DELETE /api/products/{id} -> Eliminar/desactivar producto (solo ADMIN):
//   @DeleteMapping("/{id}")
//   @PreAuthorize("hasRole('ADMIN')")
//   public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id)

public class ProductController {
}
