package com.crud.api.entity;

// TODO 1: Anotar con @Entity y @Table(name = "categories")
// TODO 2: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 3: Definir los siguientes campos:
//   - id: Long, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
//   - name: String, @Column(nullable = false, unique = true)
//   - description: String, @Column(columnDefinition = "TEXT")

// TODO 4: Definir la relación OneToMany con Product:
//   - @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//   - private List<Product> products = new ArrayList<>()
//   - IMPORTANTE: Excluir 'products' del toString() de Lombok con @ToString.Exclude
//     para evitar recursión infinita (Category.toString -> Product.toString -> Category.toString)

public class Category {
}
