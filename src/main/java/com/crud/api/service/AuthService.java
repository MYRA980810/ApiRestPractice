package com.crud.api.service;

// TODO 1: Anotar con @Service

// TODO 2: Inyectar dependencias:
//   - AuthenticationManager authenticationManager
//   - UserRepository userRepository
//   - PasswordEncoder passwordEncoder
//   - JwtTokenProvider jwtTokenProvider
//   - UserMapper userMapper

// TODO 3: Implementar login(LoginRequest request) -> AuthResponse:
//   Paso 1: Autenticar con AuthenticationManager
//     - Authentication authentication = authenticationManager.authenticate(
//         new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//       )
//     - Si las credenciales son incorrectas, AuthenticationManager lanza BadCredentialsException
//       (que será capturada por GlobalExceptionHandler)
//
//   Paso 2: Generar el token JWT
//     - String token = jwtTokenProvider.generateToken(authentication)
//
//   Paso 3: Obtener el User autenticado
//     - User user = (User) authentication.getPrincipal()
//
//   Paso 4: Construir y retornar AuthResponse usando el mapper
//     - return userMapper.toAuthResponse(user, token)

// TODO 4: Implementar register(RegisterRequest request) -> AuthResponse:
//   Paso 1: Verificar que el email no exista (doble check, además de @UniqueEmail)
//     - if (userRepository.existsByEmail(request.getEmail()))
//         throw new DuplicateResourceException("User", "email", request.getEmail())
//
//   Paso 2: Crear el User
//     - User user = userMapper.toEntity(request)
//     - user.setPassword(passwordEncoder.encode(request.getPassword()))  // Encriptar password
//     - user.setRole(Role.USER)  // Rol por defecto
//
//   Paso 3: Guardar en BD
//     - userRepository.save(user)
//
//   Paso 4: Autenticar automáticamente al usuario recién registrado
//     - Reutilizar la lógica de login para generar el token
//     - O crear el token directamente

public class AuthService {
}
