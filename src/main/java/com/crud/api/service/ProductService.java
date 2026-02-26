package com.crud.api.service;

// TODO 1: Anotar con @Service

// TODO 2: Inyectar:
//   - ProductRepository productRepository
//   - CategoryRepository categoryRepository
//   - ProductMapper productMapper

// TODO 3: Implementar findAll() -> List<ProductResponse>:
//   - @Transactional(readOnly = true)
//   - productRepository.findAll() -> productMapper.toResponseList()

// TODO 4: Implementar findById(Long id) -> ProductResponse:
//   - @Transactional(readOnly = true)
//   - Buscar producto, si no existe lanzar ResourceNotFoundException

// TODO 5: Implementar findByCategoryId(Long categoryId) -> List<ProductResponse>:
//   - @Transactional(readOnly = true)
//   - Verificar que la categoría exista primero
//   - productRepository.findByCategoryId(categoryId)

// TODO 6: Implementar create(ProductRequest request) -> ProductResponse:
//   - @Transactional
//   - Buscar la categoría por request.getCategoryId()
//   - Si no existe: throw new ResourceNotFoundException("Category", "id", request.getCategoryId())
//   - Mapear: productMapper.toEntity(request, category)
//   - Guardar y retornar response

// TODO 7: Implementar update(Long id, ProductRequest request) -> ProductResponse:
//   - @Transactional
//   - Buscar producto existente
//   - Buscar nueva categoría
//   - Actualizar con productMapper.updateEntity(product, request, category)
//   - Guardar y retornar

// TODO 8: Implementar delete(Long id) -> void:
//   - @Transactional
//   - Verificar que el producto no tenga OrderItems asociados antes de borrar
//   - O hacer soft delete: product.setActive(false) en vez de borrar

public class ProductService {
}
