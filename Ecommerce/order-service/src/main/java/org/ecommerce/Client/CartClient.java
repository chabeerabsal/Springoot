package org.ecommerce.Client;

import org.ecommerce.DTO.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "cart-service")
public interface CartClient {

    @GetMapping("/api/carts/{userId}")
    List<CartResponse> getCart(@PathVariable("userId") UUID userId);
}
