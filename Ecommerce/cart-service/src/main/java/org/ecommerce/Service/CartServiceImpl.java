package org.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.Client.ProductClient;
import org.ecommerce.DTO.CartRequest;
import org.ecommerce.DTO.CartResponse;
import org.ecommerce.Entity.Cart;
import org.ecommerce.Repo.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository repository;
    private final ProductClient productClient;

    @Override
    public CartResponse addToCart(CartRequest request) {

        log.info("Adding product {} to cart for user {}",
                request.getProductId(), request.getUserId());

        // Validate product exists
        productClient.getProduct(request.getProductId());

        Cart cart = Cart.builder()
                .userId(request.getUserId())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();

        Cart saved = repository.save(cart);

        return mapToResponse(saved);
    }

    @Override
    public List<CartResponse> getCartByUser(UUID userId) {

        log.info("Fetching cart for user {}", userId);

        return repository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private CartResponse mapToResponse(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .userId(cart.getUserId())
                .productId(cart.getProductId())
                .quantity(cart.getQuantity())
                .build();
    }
}
