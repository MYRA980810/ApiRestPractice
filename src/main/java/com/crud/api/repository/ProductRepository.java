package com.crud.api.repository;

// TODO 1: Crear interfaz que extienda JpaRepository<Product, Long>

// TODO 2: Definir métodos de consulta:
//   - List<Product> findByCategoryId(Long categoryId)
//     -> Buscar productos por categoría
//   - List<Product> findByActiveTrue()
//     -> Buscar solo productos activos
//   - List<Product> findByNameContainingIgnoreCase(String name)
//     -> Búsqueda parcial por nombre (LIKE %name%)

// TODO 3 (Opcional/Avanzado): Definir un @Query personalizado con JPQL:
//   - @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max AND p.active = true")
//     List<Product> findByPriceRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max)

public interface ProductRepository {
}
