package com.example.ProductEntity.DTO;

import com.example.ProductEntity.Modellor.CartItems;
import lombok.Data;

import java.util.List;

@Data
public class CartResponseDTO {
    int cartId;
    Long userId;
    Double totalPrice;
    List<CartItemDetails> items;

}
