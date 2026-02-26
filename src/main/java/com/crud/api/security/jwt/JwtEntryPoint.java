package com.crud.api.security.jwt;

// TODO 1: Implementar AuthenticationEntryPoint
//   - Anotar con @Component
//   - AuthenticationEntryPoint maneja los errores de autenticación (401 Unauthorized)
//   - Se invoca cuando un usuario no autenticado intenta acceder a un recurso protegido

// TODO 2: Implementar commence(HttpServletRequest request, HttpServletResponse response,
//                              AuthenticationException authException):
//   - response.setContentType("application/json")
//   - response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
//   - Escribir un JSON de error en el response:
//     response.getOutputStream().println(
//       "{ \"status\": 401, \"message\": \"No autorizado: " + authException.getMessage() + "\" }"
//     )
//   - O usar ObjectMapper para serializar un ErrorResponse

// NOTA: Sin este EntryPoint, Spring Security devolvería una página HTML de error
// Con él, devolvemos JSON consistente con el resto de la API

public class JwtEntryPoint {
}
