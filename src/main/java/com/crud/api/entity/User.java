package com.crud.api.entity;

// TODO 1: Anotar con @Entity y @Table(name = "users")
// TODO 2: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 3: Implementar UserDetails de Spring Security para integrar con el sistema de autenticación

// TODO 4: Definir los siguientes campos:
//   - id: Long, @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
//   - name: String, @Column(nullable = false)
//   - email: String, @Column(nullable = false, unique = true) -> será el username para Spring Security
//   - password: String, @Column(nullable = false)
//   - role: Role (enum), @Enumerated(EnumType.STRING), @Column(nullable = false)
//   - createdAt: LocalDateTime, @Column(updatable = false), usar @PrePersist para auto-asignar
//   - updatedAt: LocalDateTime, usar @PreUpdate para auto-actualizar

// TODO 5: Definir la relación OneToMany con Order:
//   - @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//   - private List<Order> orders = new ArrayList<>()

// TODO 6: Implementar los métodos de UserDetails:
//   - getAuthorities(): devolver role como SimpleGrantedAuthority con prefijo "ROLE_"
//   - getUsername(): devolver el email
//   - isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled(): devolver true

// TODO 7: Crear método @PrePersist onCreate() -> this.createdAt = LocalDateTime.now()
// TODO 8: Crear método @PreUpdate onUpdate() -> this.updatedAt = LocalDateTime.now()

public class User {
}
