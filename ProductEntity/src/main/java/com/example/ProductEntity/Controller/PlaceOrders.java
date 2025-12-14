package com.example.ProductEntity.Controller;

import com.example.ProductEntity.Modellor.Order.Order;
import com.example.ProductEntity.Modellor.Payment;
import com.example.ProductEntity.Service.OrderService;
import com.example.ProductEntity.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Orders")
public class PlaceOrders {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/order/{userId}")
    public Order placeOrder(@PathVariable Integer userId) {
        return orderService.placeOrder(userId);
    }

    @PostMapping("/payment/{orderId}")
    public Payment makePayment(@PathVariable Long orderId,
                               @RequestParam String method) {
        return paymentService.processPayment(orderId, method);
    }

}
