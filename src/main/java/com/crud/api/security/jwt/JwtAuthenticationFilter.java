package com.crud.api.security.jwt;

// TODO 1: Extender OncePerRequestFilter
//   - OncePerRequestFilter garantiza que el filtro se ejecute UNA sola vez por request
//   - Se ejecuta ANTES de llegar al controller, en la cadena de filtros de Spring Security

// TODO 2: Inyectar dependencias (por constructor):
//   - JwtTokenProvider jwtTokenProvider
//   - UserDetailsService userDetailsService (tu implementación UserDetailsServiceImpl)

// TODO 3: Implementar doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain):
//
//   Paso 1: Extraer el token del header Authorization
//     - String bearerToken = request.getHeader("Authorization")
//     - Verificar que no sea null y que empiece con "Bearer "
//     - Extraer el token: bearerToken.substring(7)
//
//   Paso 2: Validar el token
//     - if (token != null && jwtTokenProvider.validateToken(token))
//
//   Paso 3: Obtener el username (email) del token
//     - String username = jwtTokenProvider.getUsernameFromToken(token)
//
//   Paso 4: Cargar el UserDetails y crear el Authentication
//     - UserDetails userDetails = userDetailsService.loadUserByUsername(username)
//     - UsernamePasswordAuthenticationToken authentication =
//         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities())
//     - authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request))
//
//   Paso 5: Establecer el Authentication en el SecurityContext
//     - SecurityContextHolder.getContext().setAuthentication(authentication)
//     - Esto le dice a Spring Security: "este request está autenticado con este usuario"
//
//   Paso 6: Continuar la cadena de filtros (SIEMPRE)
//     - filterChain.doFilter(request, response)
//     - Si no se llama a doFilter, el request se detiene aquí

// FLUJO COMPLETO:
// Request -> JwtAuthenticationFilter -> SecurityContext -> Controller
// 1. El filtro extrae el JWT del header
// 2. Lo valida y obtiene el usuario
// 3. Establece la autenticación en el contexto
// 4. El controller puede acceder al usuario con @AuthenticationPrincipal o SecurityContextHolder

public class JwtAuthenticationFilter {
}
