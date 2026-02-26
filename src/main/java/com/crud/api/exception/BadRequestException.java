package com.crud.api.exception;

// TODO 1: Crear clase que extienda RuntimeException

// TODO 2: Constructor simple:
//   - public BadRequestException(String message)
//   - Llamar a super(message)

// USO: throw new BadRequestException("Stock insuficiente para el producto X")
// Se usa para errores de validación de reglas de negocio

public class BadRequestException extends RuntimeException {
}
