package com.crud.api.dto.request;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos con validaciones de Bean Validation (jakarta.validation.constraints):
//   - @NotBlank(message = "El email es obligatorio")
//     @Email(message = "El formato del email no es válido")
//     private String email;
//
//   - @NotBlank(message = "La contraseña es obligatoria")
//     private String password;

// NOTA: Los DTOs de request llevan las validaciones, NUNCA las entities directamente
// Las validaciones se activan con @Valid en el controller

public class LoginRequest {
}
