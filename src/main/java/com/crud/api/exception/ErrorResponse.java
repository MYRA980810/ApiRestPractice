package com.crud.api.exception;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos para la respuesta de error estandarizada:
//   - private int status;                    // HTTP status code
//   - private String message;                // Mensaje general del error
//   - private LocalDateTime timestamp;       // Momento en que ocurrió el error
//   - private Map<String, String> errors;    // Mapa de errores de validación (campo -> mensaje)
//     -> Se usa cuando hay múltiples errores de validación (ej: @Valid falla en varios campos)
//     -> Para errores simples este campo puede ser null

// NOTA: Esta clase es lo que el cliente recibe cuando algo falla
// Ejemplo de respuesta:
// {
//   "status": 400,
//   "message": "Error de validación",
//   "timestamp": "2024-01-15T10:30:00",
//   "errors": {
//     "email": "El formato del email no es válido",
//     "name": "El nombre es obligatorio"
//   }
// }

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, String> errors;
}
