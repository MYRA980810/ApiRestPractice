package com.crud.api.dto.response;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Hacer la clase genérica: ApiResponse<T>
//   - Servirá como wrapper estándar para TODAS las respuestas de la API

// TODO 3: Definir campos:
//   - private int status;         // HTTP status code (200, 201, 404, etc.)
//   - private String message;     // Mensaje descriptivo ("Producto creado exitosamente")
//   - private T data;             // Datos genéricos (puede ser cualquier DTO de response)

// TODO 4: Crear métodos estáticos de fábrica para facilitar la construcción:
//   - public static <T> ApiResponse<T> success(String message, T data)
//     -> return new ApiResponse<>(200, message, data)
//   - public static <T> ApiResponse<T> created(String message, T data)
//     -> return new ApiResponse<>(201, message, data)
//   - public static <T> ApiResponse<T> error(int status, String message)
//     -> return new ApiResponse<>(status, message, null)

public class ApiResponse {
}
