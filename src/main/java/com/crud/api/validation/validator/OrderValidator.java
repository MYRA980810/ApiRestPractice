package com.crud.api.validation.validator;

import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.crud.api.dto.request.OrderItemRequest;
import com.crud.api.dto.request.OrderRequest;
import com.crud.api.entity.Product;
import com.crud.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderValidator implements Validator {

    private final ProductRepository productRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return OrderRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        OrderRequest orderRequest = (OrderRequest) target;

        if (orderRequest.getItems() == null || orderRequest.getItems().isEmpty()) {
            return;
        }

        // Regla 1: Verificar que no haya productos duplicados
        Set<Long> productIds = new HashSet<>();
        for (OrderItemRequest item : orderRequest.getItems()) {
            if (item.getProductId() != null && !productIds.add(item.getProductId())) {
                errors.rejectValue("items", "order.items.duplicate",
                        "No se permiten productos duplicados en la misma orden");
                return;
            }
        }

        // Regla 2 y 3: Verificar existencia y stock de cada producto
        for (OrderItemRequest item : orderRequest.getItems()) {
            if (item.getProductId() == null) continue;

            Product product = productRepository.findById(item.getProductId()).orElse(null);

            if (product == null) {
                errors.rejectValue("items", "order.items.product.notfound",
                        "Producto con ID " + item.getProductId() + " no encontrado");
                return;
            }

            if (item.getQuantity() != null && product.getStock() < item.getQuantity()) {
                errors.rejectValue("items", "order.items.stock.insufficient",
                        "Stock insuficiente para producto " + product.getName()
                        + ". Disponible: " + product.getStock()
                        + ", Solicitado: " + item.getQuantity());
            }
        }
    }
}
