package com.crud.api.exception;

// TODO 1: Crear clase que extienda RuntimeException

// TODO 2: Constructor:
//   - public DuplicateResourceException(String resourceName, String fieldName, Object fieldValue)
//   - Llamar a super(String.format("%s ya existe con %s: '%s'", resourceName, fieldName, fieldValue))

// USO: throw new DuplicateResourceException("Category", "name", "Electrónica")
// Se lanza cuando se intenta crear un recurso que ya existe (email duplicado, nombre único, etc.)

public class DuplicateResourceException extends RuntimeException {
}
