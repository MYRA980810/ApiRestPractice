package com.crud.api.dto.request;

import java.math.BigDecimal;

import com.crud.api.validation.annotation.ValidPrice;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ProductRequest {

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 2, max = 200)
    private String name;

    private String description;

    @NotNull(message = "El precio es obligatorio")
    @ValidPrice
    private BigDecimal price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoryId;
}
