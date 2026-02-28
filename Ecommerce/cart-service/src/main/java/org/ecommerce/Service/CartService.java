package org.ecommerce.Service;

import org.ecommerce.DTO.CartRequest;
import org.ecommerce.DTO.CartResponse;

import java.util.List;
import java.util.UUID;

public interface CartService {

    CartResponse addToCart(CartRequest request);

    List<CartResponse> getCartByUser(UUID userId);
}
