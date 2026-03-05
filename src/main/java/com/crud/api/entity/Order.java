package com.crud.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    void addOrderItme(OrderItem item){
        this.items.add(item);
        item.setOrder(this);
    }

    @PrePersist
    protected void orderDate(){
        this.orderDate = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Order order))
            return false;
        return id != null && id.equals(order.id);
    }

    
}
