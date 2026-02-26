package com.crud.api.validation.validator;

// TODO 1: Implementar la interfaz org.springframework.validation.Validator
//   - Anotar con @Component
//   - Esta es la interfaz Validator de SPRING (NO de Bean Validation/Jakarta)
//   - Se usa para validaciones de reglas de negocio más complejas que requieren lógica programática

// TODO 2: Inyectar ProductRepository para verificar stock de productos

// TODO 3: Implementar supports(Class<?> clazz):
//   - return OrderRequest.class.isAssignableFrom(clazz)
//   - Indica que este validador solo funciona con objetos de tipo OrderRequest

// TODO 4: Implementar validate(Object target, Errors errors):
//   - Castear target a OrderRequest
//   - Validar reglas de negocio:
//
//   Regla 1: Verificar que no haya productos duplicados en la orden
//     - Extraer los productIds de los items
//     - Verificar que no haya duplicados con Set
//     - Si hay duplicados: errors.rejectValue("items", "order.items.duplicate",
//         "No se permiten productos duplicados en la misma orden")
//
//   Regla 2: Verificar que todos los productos existan
//     - Buscar cada productId en el repository
//     - Si alguno no existe: errors.rejectValue("items", "order.items.product.notfound",
//         "Producto con ID X no encontrado")
//
//   Regla 3: Verificar stock disponible para cada item
//     - Comparar quantity del item con stock del producto
//     - Si no hay stock suficiente: errors.rejectValue("items", "order.items.stock.insufficient",
//         "Stock insuficiente para producto X. Disponible: Y, Solicitado: Z")

// TODO 5: Usar este validador en OrderService/OrderController:
//   - Inyectar OrderValidator
//   - Antes de crear la orden, llamar:
//     orderValidator.validate(orderRequest, bindingResult)
//     if (bindingResult.hasErrors()) { lanzar excepción con los errores }
//   - O usar con @InitBinder en el controller

// DIFERENCIA CON ConstraintValidator:
//   - ConstraintValidator: se activa automáticamente con @Valid, una anotación por campo
//   - Validator (Spring): se invoca manualmente, permite validaciones cruzadas entre campos
//   - Usar ConstraintValidator para validaciones simples de un campo
//   - Usar Validator de Spring para reglas de negocio complejas que involucran múltiples campos/entidades

public class OrderValidator {
}
