package com.crud.api.repository;

// TODO 1: Crear interfaz que extienda JpaRepository<User, Long>
// TODO 2: Anotar con @Repository (opcional ya que JpaRepository ya es detectado por Spring)

// TODO 3: Definir los siguientes métodos de consulta (Query Methods de Spring Data JPA):
//   - Optional<User> findByEmail(String email)
//     -> Spring genera automáticamente el SQL: SELECT * FROM users WHERE email = ?
//   - Boolean existsByEmail(String email)
//     -> Para verificar si un email ya existe antes de registrar

// NOTA: Spring Data JPA genera la implementación automáticamente a partir del nombre del método
// Convención: findBy[Campo], existsBy[Campo], deleteBy[Campo], countBy[Campo]

public interface UserRepository {
}
