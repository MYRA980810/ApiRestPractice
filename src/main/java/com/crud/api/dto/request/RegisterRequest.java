package com.crud.api.dto.request;

// TODO 1: Usar Lombok: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

// TODO 2: Definir campos con validaciones:
//   - @NotBlank(message = "El nombre es obligatorio")
//     @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
//     private String name;
//
//   - @NotBlank(message = "El email es obligatorio")
//     @Email(message = "El formato del email no es válido")
//     @UniqueEmail  // <-- Validación personalizada que crearás en validation/annotation
//     private String email;
//
//   - @NotBlank(message = "La contraseña es obligatoria")
//     @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
//     private String password;

// NOTA: @UniqueEmail es una anotación personalizada que verificará en BD si el email ya existe
// Se implementará en validation/annotation/UniqueEmail.java y validation/validator/UniqueEmailValidator.java

public class RegisterRequest {
}
