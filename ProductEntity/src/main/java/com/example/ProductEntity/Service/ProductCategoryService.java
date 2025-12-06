package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public Optional<ProductCategory> save(ProductCategory productCategory) {
        ProductCategory products= productCategoryRepository.save(productCategory);
        return Optional.of(products);
    }



    public ProductCategory find(Long id) {
        return productCategoryRepository.findByid(id);
    }

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }
}
