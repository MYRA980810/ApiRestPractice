package com.crud.api.service;

// TODO 1: Anotar con @Service
// TODO 2: Implementar la interfaz UserDetailsService de Spring Security

// TODO 3: Inyectar UserRepository

// TODO 4: Implementar loadUserByUsername(String username) -> UserDetails:
//   - username aquí es el email (así lo configuramos en User.getUsername())
//   - Buscar en BD: userRepository.findByEmail(username)
//   - Si no existe, lanzar: new UsernameNotFoundException("Usuario no encontrado con email: " + username)
//   - Si existe, retornar el User (que implementa UserDetails)
//   - Spring Security usa este método internamente durante la autenticación

// NOTA: Este servicio es el puente entre Spring Security y nuestra base de datos
// Spring Security lo llama automáticamente cuando se hace authentication.authenticate()

public class UserDetailsServiceImpl {
}
