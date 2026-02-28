package org.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.Client.CartClient;
import org.ecommerce.Constants.OrderConstants;
import org.ecommerce.DTO.CartResponse;
import org.ecommerce.DTO.OrderRequest;
import org.ecommerce.DTO.OrderResponse;
import org.ecommerce.Entity.Order;
import org.ecommerce.Event.OrderCreatedEvent;
import org.ecommerce.Exception.ResourceNotFoundException;
import org.ecommerce.Repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CartClient cartClient;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {

        log.info("Placing order for user {}", request.getUserId());

        List<CartResponse> cartItems =
                cartClient.getCart(request.getUserId());

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = Order.builder()
                .userId(request.getUserId())
                .status("CREATED")
                .build();

        Order saved = repository.save(order);

        // Publish event
        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(saved.getId())
                .userId(saved.getUserId())
                .build();

        kafkaTemplate.send(OrderConstants.ORDER_TOPIC, event);

        log.info("Order event published for order {}", saved.getId());

        return OrderResponse.builder()
                .id(saved.getId())
                .userId(saved.getUserId())
                .status(saved.getStatus())
                .build();
    }
    @Override
    public OrderResponse getById(UUID id) {

        log.info("Fetching order with id {}", id);

        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                String.format(OrderConstants.ORDER_NOT_FOUND, id)
                        )
                );

        return mapToResponse(order);
    }
    private OrderResponse mapToResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .status(order.getStatus())
                .build();
    }
}
