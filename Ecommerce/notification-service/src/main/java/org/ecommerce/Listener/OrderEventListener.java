package org.ecommerce.Listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.Constans.NotificationConstants;
import org.ecommerce.Event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventListener {

    @KafkaListener(
            topics = NotificationConstants.ORDER_TOPIC,
            groupId = "notification-group"
    )
    public void consume(OrderCreatedEvent event) {

        log.info("Received OrderCreatedEvent for order {} and user {}",
                event.getOrderId(),
                event.getUserId());

        // Simulate sending email
        log.info("Sending order confirmation email to user {}",
                event.getUserId());
    }
}
