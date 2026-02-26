package com.crud.api.mapper;

// TODO 1: Anotar con @Component

// TODO 2: Implementar método toEntity(ProductRequest request, Category category) -> Product:
//   - Recibe la Category ya resuelta (buscada por categoryId en el servicio)
//   - Mapear: name, description, price, stock <- del request
//   - Mapear: category <- parámetro category (la entidad ya resuelta)
//   - Mapear: active <- true (default al crear)
//   - IMPORTANTE: El mapper NO busca la categoría en BD, eso es responsabilidad del servicio

// TODO 3: Implementar método toResponse(Product product) -> ProductResponse:
//   - Mapear los campos básicos: id, name, description, price, stock, active
//   - Mapear: categoryName <- product.getCategory().getName()
//   - Mapear: categoryId <- product.getCategory().getId()
//   - Retornar ProductResponse

// TODO 4: Implementar método toResponseList(List<Product> products) -> List<ProductResponse>

// TODO 5: Implementar método updateEntity(Product product, ProductRequest request, Category category):
//   - Actualizar todos los campos del producto con los del request
//   - Actualizar la categoría si cambió

public class ProductMapper {
}
