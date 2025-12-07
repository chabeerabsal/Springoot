package com.example.ProductEntity.DTO;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Modellor.Products;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    String name;
    //String  productName;
    List<ProductsDTO> productsDTO= new ArrayList<>();


    public CategoryDTO(ProductCategory products) {
        this.name = products.getName();
        if(products.getProducts()!=null){
            setProductDTO(products.getProducts());

        }
    }

    private void setProductDTO(List<Products> products) {
        for(Products product:products){
            ProductsDTO prodduct= new ProductsDTO(product);
            productsDTO.add(prodduct);
        }

    }


}
