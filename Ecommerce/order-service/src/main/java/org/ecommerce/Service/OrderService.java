package org.ecommerce.Service;

import org.ecommerce.DTO.OrderRequest;
import org.ecommerce.DTO.OrderResponse;

import java.util.UUID;

public interface OrderService {
    public OrderResponse placeOrder(OrderRequest request);

    OrderResponse getById(UUID id);
}
