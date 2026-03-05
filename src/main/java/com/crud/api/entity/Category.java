package com.crud.api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(!(obj instanceof Category category))
            return false;
        return id != null && id.equals(category.id);
    }

}
