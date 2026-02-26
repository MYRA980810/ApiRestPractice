package com.crud.api.exception;

// TODO 1: Anotar con @RestControllerAdvice
//   - Esta anotación combina @ControllerAdvice + @ResponseBody
//   - Captura excepciones de TODOS los controllers centralizadamente
//   - Elimina la necesidad de try-catch en cada controller

// TODO 2: Manejar ResourceNotFoundException -> 404 NOT_FOUND:
//   @ExceptionHandler(ResourceNotFoundException.class)
//   @ResponseStatus(HttpStatus.NOT_FOUND)
//   public ErrorResponse handleResourceNotFound(ResourceNotFoundException ex)
//   - Construir ErrorResponse con status 404, mensaje de la excepción, timestamp actual, errors null

// TODO 3: Manejar BadRequestException -> 400 BAD_REQUEST:
//   @ExceptionHandler(BadRequestException.class)
//   @ResponseStatus(HttpStatus.BAD_REQUEST)
//   public ErrorResponse handleBadRequest(BadRequestException ex)

// TODO 4: Manejar DuplicateResourceException -> 409 CONFLICT:
//   @ExceptionHandler(DuplicateResourceException.class)
//   @ResponseStatus(HttpStatus.CONFLICT)
//   public ErrorResponse handleDuplicateResource(DuplicateResourceException ex)

// TODO 5: Manejar MethodArgumentNotValidException -> 400 BAD_REQUEST (validaciones de @Valid):
//   @ExceptionHandler(MethodArgumentNotValidException.class)
//   @ResponseStatus(HttpStatus.BAD_REQUEST)
//   public ErrorResponse handleValidationErrors(MethodArgumentNotValidException ex)
//   - Extraer los errores de validación: ex.getBindingResult().getFieldErrors()
//   - Construir Map<String, String> con fieldError.getField() -> fieldError.getDefaultMessage()
//   - IMPORTANTE: Este es el handler que captura las validaciones de @NotBlank, @Email, @Size, etc.

// TODO 6: Manejar ConstraintViolationException -> 400 BAD_REQUEST (validaciones de @Validated):
//   @ExceptionHandler(ConstraintViolationException.class)
//   @ResponseStatus(HttpStatus.BAD_REQUEST)
//   public ErrorResponse handleConstraintViolation(ConstraintViolationException ex)
//   - Extraer: ex.getConstraintViolations() -> mapear propertyPath y message

// TODO 7: Manejar AccessDeniedException -> 403 FORBIDDEN:
//   @ExceptionHandler(AccessDeniedException.class)
//   @ResponseStatus(HttpStatus.FORBIDDEN)
//   public ErrorResponse handleAccessDenied(AccessDeniedException ex)

// TODO 8: Manejar Exception genérica -> 500 INTERNAL_SERVER_ERROR (catch-all):
//   @ExceptionHandler(Exception.class)
//   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//   public ErrorResponse handleGenericException(Exception ex)
//   - Loguear el error con un logger
//   - NO exponer detalles internos al cliente, devolver mensaje genérico

// NOTA: El orden de los handlers importa. Spring busca el handler más específico primero.
// Si ningún handler específico coincide, cae en el handler de Exception genérica.

public class GlobalExceptionHandler {
}
