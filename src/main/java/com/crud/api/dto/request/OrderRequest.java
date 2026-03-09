package com.crud.api.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotNull(message = "Los items de la orden son obligatorios")
    @Size(min = 1, message = "La orden debe tener al menos un item")
    @Valid
    private List<OrderItemRequest> items;
}
