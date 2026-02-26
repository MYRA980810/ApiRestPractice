package com.crud.api.mapper;

// TODO 1: Anotar con @Component para que Spring lo inyecte donde se necesite

// TODO 2: Implementar método toEntity(CategoryRequest request) -> Category:
//   - Crear instancia de Category (con builder o constructor)
//   - Mapear: name <- request.getName()
//   - Mapear: description <- request.getDescription()
//   - Retornar la entity Category
//   - NOTA: NO se setea el id porque es autogenerado

// TODO 3: Implementar método toResponse(Category category) -> CategoryResponse:
//   - Mapear: id <- category.getId()
//   - Mapear: name <- category.getName()
//   - Mapear: description <- category.getDescription()
//   - Mapear: productCount <- category.getProducts() != null ? category.getProducts().size() : 0
//   - Retornar CategoryResponse

// TODO 4: Implementar método toResponseList(List<Category> categories) -> List<CategoryResponse>:
//   - Usar stream().map(this::toResponse).collect(Collectors.toList())
//   - Este patrón se repite en todos los mappers para listas

// TODO 5: Implementar método updateEntity(Category category, CategoryRequest request) -> Category:
//   - category.setName(request.getName())
//   - category.setDescription(request.getDescription())
//   - Retornar la entity actualizada
//   - Se usa en el update del servicio para no crear una nueva instancia

// NOTA: Este es un mapper MANUAL (sin MapStruct ni ModelMapper).
// Ventaja: control total sobre qué campos se mapean y cómo.
// En proyectos grandes se puede usar MapStruct para generar mappers automáticos en compilación.

public class CategoryMapper {
}
