package com.crud.api.repository;

// TODO 1: Crear interfaz que extienda JpaRepository<Order, Long>

// TODO 2: Definir métodos de consulta:
//   - List<Order> findByUserId(Long userId)
//     -> Obtener todas las órdenes de un usuario
//   - List<Order> findByStatus(String status)
//     -> Filtrar órdenes por estado (PENDING, CONFIRMED, CANCELLED)

// TODO 3 (Opcional): @Query con JOIN FETCH para evitar problema N+1:
//   - @Query("SELECT o FROM Order o JOIN FETCH o.items WHERE o.id = :id")
//     Optional<Order> findByIdWithItems(@Param("id") Long id)
//   - Esto carga la orden junto con sus items en una sola consulta SQL

public interface OrderRepository {
}
