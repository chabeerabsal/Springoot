package com.example.ProductEntity.DTO;

import com.example.ProductEntity.Modellor.Products;
import lombok.Data;

@Data
public class ProductsDTO {
    String  productName;
    String productDescription;
    Double productPrice;
    Integer productQuantity;
    public ProductsDTO(Products products) {
        this.productName = products.getProductName();
        this.productDescription = products.getProductDescription();
        this.productPrice = products.getProductPrice();
        this.productQuantity = products.getProductQuantity();
    }
}
