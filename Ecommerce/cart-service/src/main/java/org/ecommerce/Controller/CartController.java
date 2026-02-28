package org.ecommerce.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ecommerce.DTO.CartRequest;
import org.ecommerce.DTO.CartResponse;
import org.ecommerce.Service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.ecommerce.Constants.CartConstants.BASE_PATH;
import static org.ecommerce.Constants.CartConstants.GET_BY_USER;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponse> add(
            @Valid @RequestBody CartRequest request) {

        return new ResponseEntity<>(
                cartService.addToCart(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping(GET_BY_USER)
    public ResponseEntity<List<CartResponse>> get(
            @PathVariable("userId") UUID userId) {

        return ResponseEntity.ok(
                cartService.getCartByUser(userId)
        );
    }
}
