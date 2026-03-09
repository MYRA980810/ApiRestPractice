package com.crud.api.validation.validator;

import java.math.BigDecimal;

import com.crud.api.validation.annotation.ValidPrice;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// TODO 1: Implementar ConstraintValidator<ValidPrice, BigDecimal>

// TODO 2: Implementar isValid(BigDecimal price, ConstraintValidatorContext context):
//   - Si price es null, retornar true (dejar que @NotNull maneje el null)
//   - Verificar que price.compareTo(BigDecimal.ZERO) > 0 (mayor a cero)
//   - Verificar que price.scale() <= 2 (máximo 2 decimales)
//   - Retornar true solo si ambas condiciones se cumplen

// NOTA: Este validador NO necesita acceso a BD, es puramente lógica de formato
// A diferencia de UniqueEmailValidator, no requiere inyección de dependencias

public class ValidPriceValidator implements ConstraintValidator<ValidPrice, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal price, ConstraintValidatorContext context) {
        if (price == null) {
            return true; // Dejar que @NotNull maneje el null
        }
        return price.compareTo(BigDecimal.ZERO) > 0 && price.scale() <= 2;
    }
}
