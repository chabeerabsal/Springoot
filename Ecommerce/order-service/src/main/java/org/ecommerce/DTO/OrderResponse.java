package org.ecommerce.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private UUID id;
    private UUID userId;
    private String status;
}
