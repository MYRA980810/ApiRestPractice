package com.crud.api.controller;

// TODO 1: Anotar con @RestController y @RequestMapping("/api/auth")

// TODO 2: Inyectar AuthService

// TODO 3: Implementar endpoint POST /api/auth/login:
//   @PostMapping("/login")
//   public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request)
//   - Llamar a authService.login(request)
//   - Retornar ResponseEntity.ok(ApiResponse.success("Login exitoso", authResponse))
//   - @Valid activa las validaciones de @NotBlank, @Email en LoginRequest

// TODO 4: Implementar endpoint POST /api/auth/register:
//   @PostMapping("/register")
//   public ResponseEntity<ApiResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request)
//   - Llamar a authService.register(request)
//   - Retornar ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created("Registro exitoso", authResponse))
//   - @Valid activa @NotBlank, @Email, @Size Y también @UniqueEmail (validación personalizada)

// NOTA: Estos endpoints son públicos (permitAll en SecurityConfig)
// No requieren token JWT para acceder

public class AuthController {
}
