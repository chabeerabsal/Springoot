package org.ecommerce.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartRequest {

    @NotNull(message = "UserId is required")
    private UUID userId;

    @NotNull(message = "ProductId is required")
    private UUID productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}