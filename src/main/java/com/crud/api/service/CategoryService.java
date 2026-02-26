package com.crud.api.service;

// TODO 1: Anotar con @Service

// TODO 2: Inyectar:
//   - CategoryRepository categoryRepository
//   - CategoryMapper categoryMapper

// TODO 3: Implementar findAll() -> List<CategoryResponse>:
//   - categoryRepository.findAll()
//   - Mapear con categoryMapper.toResponseList()

// TODO 4: Implementar findById(Long id) -> CategoryResponse:
//   - categoryRepository.findById(id)
//   - Si no existe: throw new ResourceNotFoundException("Category", "id", id)
//   - Mapear con categoryMapper.toResponse()

// TODO 5: Implementar create(CategoryRequest request) -> CategoryResponse:
//   - Verificar que no exista otra categoría con el mismo nombre:
//     if (categoryRepository.existsByName(request.getName()))
//       throw new DuplicateResourceException("Category", "name", request.getName())
//   - Mapear request a entity: categoryMapper.toEntity(request)
//   - Guardar: categoryRepository.save(category)
//   - Retornar: categoryMapper.toResponse(savedCategory)

// TODO 6: Implementar update(Long id, CategoryRequest request) -> CategoryResponse:
//   - Buscar la categoría existente (si no existe, lanzar ResourceNotFoundException)
//   - Verificar que el nuevo nombre no esté en uso por OTRA categoría
//   - Actualizar con categoryMapper.updateEntity(category, request)
//   - Guardar y retornar

// TODO 7: Implementar delete(Long id) -> void:
//   - Verificar que existe
//   - categoryRepository.deleteById(id)
//   - Considerar: ¿qué pasa con los productos asociados? (cascade o excepción)

// TODO 8: Anotar los métodos con @Transactional donde corresponda:
//   - @Transactional en create, update, delete (escritura)
//   - @Transactional(readOnly = true) en findAll, findById (solo lectura, optimiza rendimiento)

public class CategoryService {
}
