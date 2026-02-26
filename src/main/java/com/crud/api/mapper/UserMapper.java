package com.crud.api.mapper;

// TODO 1: Anotar con @Component

// TODO 2: Implementar método toEntity(RegisterRequest request) -> User:
//   - Mapear: name, email <- del request
//   - password: NO mapear aquí, se encripta en el servicio con PasswordEncoder
//   - role: se asigna en el servicio (por defecto USER)
//   - Retornar User sin password ni role (los setea el servicio)

// TODO 3: Implementar método toAuthResponse(User user, String token) -> AuthResponse:
//   - Mapear: token <- parámetro token
//   - Mapear: type <- "Bearer"
//   - Mapear: email <- user.getEmail()
//   - Mapear: name <- user.getName()
//   - Mapear: role <- user.getRole().name()

public class UserMapper {
}
