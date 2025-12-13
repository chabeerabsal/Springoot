package com.example.ProductEntity.DTO;

import lombok.Data;

@Data
public class CartItemDetails {
    Long productId;
    int quantity;
    String productName;
    Double price;
}
