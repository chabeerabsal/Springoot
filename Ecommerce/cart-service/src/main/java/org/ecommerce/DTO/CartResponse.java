package org.ecommerce.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private UUID id;
    private UUID userId;
    private UUID productId;
    private Integer quantity;
}
