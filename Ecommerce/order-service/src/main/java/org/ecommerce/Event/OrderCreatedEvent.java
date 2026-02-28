package org.ecommerce.Event;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreatedEvent {

    private UUID orderId;
    private UUID userId;
}
