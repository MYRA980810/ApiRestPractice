package com.crud.api.controller;

// TODO 1: Anotar con @RestController y @RequestMapping("/api/categories")

// TODO 2: Inyectar CategoryService

// TODO 3: GET /api/categories -> Listar todas las categorías:
//   @GetMapping
//   public ResponseEntity<ApiResponse<List<CategoryResponse>>> findAll()
//   - Es público (configurado en SecurityConfig)

// TODO 4: GET /api/categories/{id} -> Obtener categoría por ID:
//   @GetMapping("/{id}")
//   public ResponseEntity<ApiResponse<CategoryResponse>> findById(@PathVariable Long id)

// TODO 5: POST /api/categories -> Crear categoría (requiere autenticación):
//   @PostMapping
//   @PreAuthorize("hasRole('ADMIN')")  // Solo ADMIN puede crear categorías
//   public ResponseEntity<ApiResponse<CategoryResponse>> create(@Valid @RequestBody CategoryRequest request)
//   - Retornar HttpStatus.CREATED

// TODO 6: PUT /api/categories/{id} -> Actualizar categoría:
//   @PutMapping("/{id}")
//   @PreAuthorize("hasRole('ADMIN')")
//   public ResponseEntity<ApiResponse<CategoryResponse>> update(@PathVariable Long id,
//                                                                @Valid @RequestBody CategoryRequest request)

// TODO 7: DELETE /api/categories/{id} -> Eliminar categoría:
//   @DeleteMapping("/{id}")
//   @PreAuthorize("hasRole('ADMIN')")
//   public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id)
//   - Retornar ResponseEntity.ok(ApiResponse.success("Categoría eliminada", null))

// NOTA: @PreAuthorize requiere @EnableMethodSecurity en SecurityConfig
// hasRole('ADMIN') verifica que el usuario tenga el rol ROLE_ADMIN

public class CategoryController {
}
