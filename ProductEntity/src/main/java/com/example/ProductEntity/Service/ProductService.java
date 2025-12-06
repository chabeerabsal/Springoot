package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Modellor.Products;
import com.example.ProductEntity.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService()
    {

    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> save(Products product, ProductCategory productCategory) {

        product.setProductCategory(productCategory);
        productRepository.save(product);
        return productRepository.findAll();
    }

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    public List<Products> findAll() {
        return productRepository.findAll();
    }
}
