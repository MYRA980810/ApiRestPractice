package com.crud.api.entity;

// TODO 1: Anotar con @Entity y @Table(name = "orders")
// TODO 2: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 3: Definir los siguientes campos:
//   - id: Long, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
//   - orderDate: LocalDateTime, @Column(nullable = false), auto-asignar con @PrePersist
//   - status: String, @Column(nullable = false) -> valores: PENDING, CONFIRMED, CANCELLED
//   - total: BigDecimal, @Column(nullable = false, precision = 10, scale = 2)
//     (se calculará sumando price * quantity de cada OrderItem)

// TODO 4: Definir la relación ManyToOne con User:
//   - @ManyToOne(fetch = FetchType.LAZY)
//   - @JoinColumn(name = "user_id", nullable = false)
//   - private User user
//   - @ToString.Exclude para evitar recursión

// TODO 5: Definir la relación OneToMany con OrderItem:
//   - @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//   - private List<OrderItem> items = new ArrayList<>()
//   - Esta relación permite que al guardar una Order, se guarden también sus items (cascade ALL)
//   - orphanRemoval = true: si se elimina un item de la lista, se borra de la BD

// TODO 6: Crear método helper addItem(OrderItem item):
//   - items.add(item)
//   - item.setOrder(this)
//   - Esto mantiene la bidireccionalidad de la relación sincronizada

// TODO 7: Crear @PrePersist para auto-asignar orderDate con LocalDateTime.now()

public class Order {
}
