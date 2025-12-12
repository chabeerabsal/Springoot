package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.Products;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.CardRepo;
import com.example.ProductEntity.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CardRepo cartItemRepository;

    public CartResponseDTO addToCart(User user, AddToCartDTO request) {

        // 1️⃣ Get product
        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 2️⃣ Get or create cart for user
        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> createNewCart(user));


        // 3️⃣ Check if product already exists in cart (NO STREAM)
        CartItem existingItem = null;

        List<CartItem> cartItems = cart.getItems();
        if (cartItems != null) {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == product.getId()) {
                    existingItem = cartItem;
                    break;
                }
            }
        }

        CartItem item;

        if (existingItem != null) {
            // Increase quantity
            item = existingItem;
            item.setQuantity(item.getQuantity() + request.getQuantity());
        } else {
            // Create new cart item
            item = new CartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(request.getQuantity());
        }

        cartItemRepository.save(item);

        // 4️⃣ Recalculate total price
        Double total = cartItemRepository.sumTotal(cart.getId());
        if (total == null) {
            total = 0.0;
        }
        cart.setTotalPrice(total);
        cartRepository.save(cart);

        // 5️⃣ Build response without streams
        return buildResponse(cart);
    }

    private Cart createNewCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }

    private CartResponseDTO buildResponse(Cart cart) {

        CartResponseDTO response = new CartResponseDTO();
        response.setCartId(cart.getId());
        response.setUserId(cart.getUser().getId());
        response.setTotalPrice(cart.getTotalPrice());

        // Convert items manually (NO STREAM)
        List<CartItemDetails> itemDetailsList = new ArrayList<>();

        if (cart.getItems() != null) {
            for (CartItem item : cart.getItems()) {
                CartItemDetails details = new CartItemDetails();
                details.setProductId(item.getProduct().getId());
                details.setProductName(item.getProduct().getProductName());
                details.setQuantity(item.getQuantity());
                details.setPrice(item.getProduct().getProductPrice());
                itemDetailsList.add(details);
            }
        }

        response.setItems(itemDetailsList);

        return response;
    }
}
