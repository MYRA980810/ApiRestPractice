package com.crud.api.validation.validator;

import com.crud.api.repository.UserRepository;
import com.crud.api.validation.annotation.UniqueEmail;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// TODO 1: Implementar ConstraintValidator<UniqueEmail, String>
//   - ConstraintValidator es la interfaz de Bean Validation para lógica de validación custom
//   - El primer genérico es la anotación (@UniqueEmail)
//   - El segundo genérico es el tipo del campo a validar (String para email)

// TODO 2: Inyectar UserRepository con @Autowired o constructor

// TODO 3: Implementar el método initialize(UniqueEmail constraintAnnotation):
//   - Método opcional, se puede dejar vacío
//   - Se usa para leer parámetros de la anotación si los tuviera

// TODO 4: Implementar el método isValid(String email, ConstraintValidatorContext context):
//   - Si email es null o vacío, retornar true (dejar que @NotBlank se encargue de eso)
//   - Retornar !userRepository.existsByEmail(email)
//   - Si retorna false, la validación falla y se muestra el message de @UniqueEmail

// NOTA: Spring inyecta dependencias automáticamente en los ConstraintValidator
// porque los gestiona como beans del contexto de aplicación

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        // No se necesita inicialización adicional
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return true; // Dejar que @NotBlank maneje esto
        }
        return !userRepository.existByEmail(email);
    }
}
