package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.CartItems;
import com.example.ProductEntity.Modellor.Order.Order;
import com.example.ProductEntity.Modellor.Order.OrderItem;
import com.example.ProductEntity.Modellor.Order.OrderStatus;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.CardRepo;
import com.example.ProductEntity.Repository.OrderRepository;
import com.example.ProductEntity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CardRepo cartRepo;
    public Order placeOrder(Integer userId) {

        User user = userRepo.findById(userId).orElseThrow();
        Cart cart = cartRepo.findByUserId(userId);

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.CREATED);

        double total = 0;

        for (CartItems c : cart.getCardItems()) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(c.getProducts());
            item.setQuantity(c.getQuantity());
            item.setPrice(c.getProducts().getProductPrice());

            order.getItems().add(item);
            total += c.getProducts().getProductPrice() * c.getQuantity();
        }

        order.setTotalAmount(total);

        Order savedOrder = orderRepo.save(order);

        cartRepo.delete(cart);  // Clear cart

        return savedOrder;
    }

}
