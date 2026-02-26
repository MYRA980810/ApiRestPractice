package com.crud.api.exception;

// TODO 1: Crear clase que extienda RuntimeException

// TODO 2: Definir campos para hacer el mensaje dinámico:
//   - private String resourceName;   // "Product", "Category", etc.
//   - private String fieldName;      // "id", "email", etc.
//   - private Object fieldValue;     // El valor buscado

// TODO 3: Crear constructor:
//   - public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue)
//   - Llamar a super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue))
//   - Asignar los campos

// USO: throw new ResourceNotFoundException("Product", "id", productId)
// MENSAJE: "Product no encontrado con id: '5'"

public class ResourceNotFoundException extends RuntimeException {
}
