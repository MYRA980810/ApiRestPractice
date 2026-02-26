package com.crud.api.exception;

public class InvalidEnumValueException extends RuntimeException {

    public InvalidEnumValueException(Class<? extends Enum<?>> enumClass, String invalidValue) {
        super(String.format(
                "Valor '%s' no es válido para el tipo '%s'",
                invalidValue, enumClass.getSimpleName()
        ));
    }
}
