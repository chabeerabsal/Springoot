package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.Order.Order;
import com.example.ProductEntity.Modellor.Order.OrderStatus;
import com.example.ProductEntity.Modellor.Payment;
import com.example.ProductEntity.Modellor.PaymentStatus;
import com.example.ProductEntity.Repository.OrderRepository;
import com.example.ProductEntity.Repository.PaymentRepository;
import com.example.ProductEntity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;
    private UserRepository userRepo;
    @Autowired
    private OrderRepository orderRepo;
    public Payment processPayment(Long orderId, String method) {

        Order order = orderRepo.findById(orderId).orElseThrow();

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentMethod(method);

        // mock payment success
        boolean success = true;

        if (success) {
            payment.setStatus(PaymentStatus.SUCCESS);
            order.setStatus(OrderStatus.CONFIRMED);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
            order.setStatus(OrderStatus.FAILED);
        }

        Payment savedPayment = paymentRepo.save(payment);
        orderRepo.save(order);

        return savedPayment;
    }
}

