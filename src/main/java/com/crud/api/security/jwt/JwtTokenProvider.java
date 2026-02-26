package com.crud.api.security.jwt;

// TODO 1: Anotar con @Component

// TODO 2: Inyectar las propiedades de JWT desde application.yml:
//   @Value("${jwt.secret}")
//   private String jwtSecret;
//   @Value("${jwt.expiration}")
//   private long jwtExpiration;

// TODO 3: Crear método privado getSigningKey() -> SecretKey:
//   - Decodificar jwtSecret de Base64: Decoders.BASE64.decode(jwtSecret)
//   - Retornar: Keys.hmacShaKeyFor(keyBytes)
//   - Este método centraliza la generación de la clave de firma

// TODO 4: Implementar generateToken(Authentication authentication) -> String:
//   - Obtener el UserDetails del authentication: (UserDetails) authentication.getPrincipal()
//   - Construir el token con Jwts.builder():
//     .subject(userDetails.getUsername())  // El email del usuario
//     .issuedAt(new Date())                // Fecha de emisión
//     .expiration(new Date(System.currentTimeMillis() + jwtExpiration))  // Expiración
//     .signWith(getSigningKey())            // Firmar con la clave secreta
//     .compact()                            // Generar el string JWT

// TODO 5: Implementar getUsernameFromToken(String token) -> String:
//   - Parsear el token con Jwts.parser()
//     .verifyWith(getSigningKey())
//     .build()
//     .parseSignedClaims(token)
//     .getPayload()
//     .getSubject()
//   - Retorna el email (subject) extraído del token

// TODO 6: Implementar validateToken(String token) -> boolean:
//   - Intentar parsear el token (mismo código que TODO 5)
//   - Si no lanza excepción, retornar true
//   - Capturar las siguientes excepciones y retornar false:
//     - MalformedJwtException: token con formato inválido
//     - ExpiredJwtException: token expirado
//     - UnsupportedJwtException: token no soportado
//     - IllegalArgumentException: claims vacíos
//   - Loguear cada tipo de error con un logger

// NOTA: Se usa la librería JJWT (io.jsonwebtoken) versión 0.12.x
// La API cambió significativamente de 0.11.x a 0.12.x (métodos como setSubject -> subject)

public class JwtTokenProvider {
}
