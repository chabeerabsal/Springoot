package org.ecommerce.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderRequest {

    @NotNull
    private UUID userId;
}
