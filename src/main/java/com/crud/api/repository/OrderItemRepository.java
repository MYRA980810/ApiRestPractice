package com.crud.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.entity.OrderItem;

// TODO 1: Crear interfaz que extienda JpaRepository<OrderItem, Long>

// TODO 2: Definir métodos de consulta:
//   - List<OrderItem> findByOrderId(Long orderId)
//   - List<OrderItem> findByProductId(Long productId)

public interface OrderItemRepository extends JpaRepository<Long, OrderItem> {
    List<OrderItem> findByOrderId(Long id);
    List<OrderItem> findByProductId(Long productId);
}
