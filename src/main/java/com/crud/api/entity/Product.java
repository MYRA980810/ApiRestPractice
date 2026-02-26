package com.crud.api.entity;

// TODO 1: Anotar con @Entity y @Table(name = "products")
// TODO 2: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 3: Definir los siguientes campos:
//   - id: Long, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
//   - name: String, @Column(nullable = false)
//   - description: String, @Column(columnDefinition = "TEXT")
//   - price: BigDecimal, @Column(nullable = false, precision = 10, scale = 2)
//   - stock: Integer, @Column(nullable = false)
//   - active: Boolean, @Column(nullable = false), default true

// TODO 4: Definir la relación ManyToOne con Category:
//   - @ManyToOne(fetch = FetchType.LAZY)
//   - @JoinColumn(name = "category_id", nullable = false)
//   - private Category category
//   - IMPORTANTE: Excluir 'category' del toString() con @ToString.Exclude para evitar recursión

// TODO 5: Definir la relación OneToMany con OrderItem (lado inverso):
//   - @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//   - private List<OrderItem> orderItems = new ArrayList<>()
//   - Excluir del toString() también

public class Product {
}
