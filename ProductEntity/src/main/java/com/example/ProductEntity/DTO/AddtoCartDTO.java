package com.example.ProductEntity.DTO;

import lombok.Data;

@Data
public class AddtoCartDTO {
    private int userId;
    private Long productId;
    private int quantity;
}
