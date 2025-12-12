package com.example.ProductEntity.DTO;

import lombok.Data;

@Data
public class AddtoCartDTO {
    private int userId;
    private int productId;
    private int quantity;
}
