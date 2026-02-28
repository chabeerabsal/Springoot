package org.ecommerce.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ecommerce.DTO.OrderRequest;
import org.ecommerce.DTO.OrderResponse;
import org.ecommerce.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.ecommerce.Constants.OrderConstants.BASE_PATH;
import static org.ecommerce.Constants.OrderConstants.GET_BY_ID;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(
            @Valid @RequestBody OrderRequest request) {

        return new ResponseEntity<>(
                orderService.placeOrder(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<OrderResponse> get(
            @PathVariable("id") UUID id) {

        // simple fetch
        return ResponseEntity.ok(
                orderService.getById(id)
        );
    }
}
