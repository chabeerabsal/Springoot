package com.example.ProductEntity.Service;

import com.example.ProductEntity.DTO.AddtoCartDTO;
import com.example.ProductEntity.DTO.CartItemDetails;
import com.example.ProductEntity.DTO.CartResponseDTO;
import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.CartItems;
import com.example.ProductEntity.Modellor.Products;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.CardRepo;
import com.example.ProductEntity.Repository.CartItemsRepository;
import com.example.ProductEntity.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CardRepo cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemsRepository cartItemRepository;

    public CartResponseDTO addToCart(User user, AddtoCartDTO request) {


        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


        Cart cart = cartRepository.findByuser(user)
                .orElseGet(() -> createNewCart(user));



        CartItems existingItem = null;

        List<CartItems> cartItems = cart.getCardItems();
        if (cartItems != null) {
            for (CartItems cartItem : cartItems) {
                if (cartItem.getProducts().getId() == product.getId()) {
                    existingItem = cartItem;
                    break;
                }
            }
        }

        CartItems item;

        if (existingItem != null) {
            // Increase quantity
            item = existingItem;
            item.setQuantity(item.getQuantity() + request.getQuantity());
        } else {
            // Create new cart item
            item = new CartItems();
            item.setCart(cart);
            item.setProducts(product);
            item.setQuantity(request.getQuantity());
        }

        cartItemRepository.save(item);

        // 4️⃣ Recalculate total price
        Double total = cartItemRepository.getCartTotal(cart.getId());
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

        if (cart.getCardItems() != null) {
            for (CartItems item : cart.getCardItems()) {
                CartItemDetails details = new CartItemDetails();
                details.setProductId(item.getProducts().getId());
                details.setProductName(item.getProducts().getProductName());
                details.setQuantity(item.getQuantity());
                details.setPrice(item.getProducts().getProductPrice());
                itemDetailsList.add(details);
            }
        }

        response.setItems(itemDetailsList);

        return response;
    }
}
