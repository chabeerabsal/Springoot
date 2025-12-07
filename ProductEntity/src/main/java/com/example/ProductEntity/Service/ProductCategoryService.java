package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Modellor.Products;
import com.example.ProductEntity.Repository.ProductCategoryRepository;
import jakarta.transaction.Transactional;
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

    public ProductCategory findById(Long id) {

        return productCategoryRepository.findByid(id);
    }
    @Transactional
    public ProductCategory addCategoy(Long id, ProductCategory productCategory) {
        ProductCategory products= productCategoryRepository.findByid(id);
        if(products==null){
            throw new RuntimeException("Category not found");
        }
        products.setName(productCategory.getName());
        if(productCategory.getProducts()!=null){
            products.getProducts().clear();
            for(Products p:productCategory.getProducts()){

                p.setProductCategory(products);
                products.getProducts().add(p);
            }
        }
        return productCategoryRepository.save(products);
    }


    @Transactional
    public ProductCategory updateCategory(Long id, ProductCategory updatedCategory) {
        ProductCategory existingCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Update category name
        existingCategory.setName(updatedCategory.getName());

        // Update products
        List<Products> updatedProducts = updatedCategory.getProducts();
        if (updatedProducts != null) {
            // Remove orphans
            existingCategory.getProducts().clear();

            // Add/update children
            for (Products p : updatedProducts) {
                // If p has an id, it will update existing; if null, it will insert new
                p.setProductCategory(existingCategory);
                existingCategory.getProducts().add(p);
            }
        }

        return productCategoryRepository.save(existingCategory);
    }

    public void deleteProducts(Long delete) {
        ProductCategory products= productCategoryRepository.findByid(delete);

        if(products==null){
            throw new RuntimeException("Category not found");
        }


       productCategoryRepository.delete(products);
    }
}



