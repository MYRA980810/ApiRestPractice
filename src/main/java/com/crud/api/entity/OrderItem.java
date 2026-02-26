package com.crud.api.entity;

// TODO 1: Anotar con @Entity y @Table(name = "order_items")
// TODO 2: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 3: Definir los siguientes campos:
//   - id: Long, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
//   - quantity: Integer, @Column(nullable = false)
//   - unitPrice: BigDecimal, @Column(nullable = false, precision = 10, scale = 2)
//     (se copia del precio del Product al momento de crear la orden)
//   - subtotal: BigDecimal, @Column(nullable = false, precision = 10, scale = 2)
//     (quantity * unitPrice, calcular con @PrePersist)

// TODO 4: Definir la relación ManyToOne con Order:
//   - @ManyToOne(fetch = FetchType.LAZY)
//   - @JoinColumn(name = "order_id", nullable = false)
//   - private Order order
//   - @ToString.Exclude

// TODO 5: Definir la relación ManyToOne con Product:
//   - @ManyToOne(fetch = FetchType.LAZY)
//   - @JoinColumn(name = "product_id", nullable = false)
//   - private Product product
//   - @ToString.Exclude

// TODO 6: Crear @PrePersist para calcular subtotal = unitPrice * quantity
//   - Esto actúa como una tabla intermedia enriquecida (relación ManyToMany entre Order y Product)
//   - Patrón común cuando una relación many-to-many necesita campos extra (quantity, price)

public class OrderItem {
}
