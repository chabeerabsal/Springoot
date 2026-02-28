package org.ecommerce.Constants;

public final class OrderConstants {

    private OrderConstants() {}

    public static final String BASE_PATH = "/api/orders";
    public static final String GET_BY_ID = "/{id}";

    public static final String ORDER_TOPIC = "order-created";
    public static final String ORDER_NOT_FOUND = "Order not found with id: %s";
}
