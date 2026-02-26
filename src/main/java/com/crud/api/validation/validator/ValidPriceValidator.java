package com.crud.api.validation.validator;

// TODO 1: Implementar ConstraintValidator<ValidPrice, BigDecimal>

// TODO 2: Implementar isValid(BigDecimal price, ConstraintValidatorContext context):
//   - Si price es null, retornar true (dejar que @NotNull maneje el null)
//   - Verificar que price.compareTo(BigDecimal.ZERO) > 0 (mayor a cero)
//   - Verificar que price.scale() <= 2 (máximo 2 decimales)
//   - Retornar true solo si ambas condiciones se cumplen

// NOTA: Este validador NO necesita acceso a BD, es puramente lógica de formato
// A diferencia de UniqueEmailValidator, no requiere inyección de dependencias

public class ValidPriceValidator {
}
