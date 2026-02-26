package com.crud.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

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

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Esta excepción se lanza cuando se intenta convertir un valor no válido a un enum específico,
    // por ejemplo, si el cliente envía un valor de rol que no existe en el enum Role. 
    // Es una excepción personalizada que puedes definir para manejar este caso específico.
    @ExceptionHandler(InvalidEnumValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEnumValue(InvalidEnumValueException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    //Esta excepción se lanza cuando el JSON del request no se puede parsear correctamente, 
    // por ejemplo, si el formato es incorrecto o si se intenta mapear un valor no válido a un enum.
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Invalid request body format")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
