package com.crud.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.api.entity.Product;

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

public interface ProductRepository extends JpaRepository<Long, Product>{
    List<Product> findByCategoryId(Long category);
    List<Product> findByActiveTrue();
    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max AND p.active = true")
    List<Product> findByPriceRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

}
