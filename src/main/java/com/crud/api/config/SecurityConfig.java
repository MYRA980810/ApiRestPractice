package com.crud.api.config;

// TODO 1: Anotar con @Configuration y @EnableMethodSecurity
//   - @Configuration: indica que esta clase contiene beans de configuración
//   - @EnableMethodSecurity: habilita @PreAuthorize y @Secured en los controllers/services

// TODO 2: Inyectar dependencias (por constructor):
//   - JwtAuthenticationFilter jwtAuthenticationFilter
//   - JwtEntryPoint jwtEntryPoint
//   - UserDetailsService userDetailsService

// TODO 3: Crear bean PasswordEncoder:
//   @Bean
//   public PasswordEncoder passwordEncoder()
//   - return new BCryptPasswordEncoder()
//   - BCrypt es el estándar para hashear contraseñas (incluye salt automático)

// TODO 4: Crear bean AuthenticationManager:
//   @Bean
//   public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
//   - return config.getAuthenticationManager()
//   - Spring Boot autoconfigura el AuthenticationManager usando el UserDetailsService y PasswordEncoder

// TODO 5: Crear bean SecurityFilterChain:
//   @Bean
//   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//
//   Configurar:
//   - csrf(csrf -> csrf.disable())
//     -> Deshabilitar CSRF porque usamos JWT (stateless, no cookies)
//
//   - exceptionHandling(ex -> ex.authenticationEntryPoint(jwtEntryPoint))
//     -> Usar nuestro JwtEntryPoint para errores 401
//
//   - sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//     -> No crear sesiones HTTP, cada request se autentica por token
//
//   - authorizeHttpRequests(auth -> auth
//       .requestMatchers("/api/auth/**").permitAll()           // Login y registro son públicos
//       .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()  // Consultar productos es público
//       .requestMatchers(HttpMethod.GET, "/api/categories/**").permitAll() // Consultar categorías es público
//       .requestMatchers("/api/admin/**").hasRole("ADMIN")     // Solo ADMIN
//       .anyRequest().authenticated()                          // Todo lo demás requiere autenticación
//     )
//
//   - addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//     -> Agregar nuestro filtro JWT ANTES del filtro de autenticación por defecto
//
//   - return http.build()

// FLUJO DE SECURITY:
// Request -> CSRF check (disabled) -> JwtAuthenticationFilter -> Authorization check -> Controller
// Si falla autenticación -> JwtEntryPoint (401)
// Si falla autorización -> AccessDeniedException -> GlobalExceptionHandler (403)

public class SecurityConfig {
}
