package com.example.ProductEntity.Controller;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ProductCategoryService categoryService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAll(){
        List<ProductCategory> allProducts=productCategoryService.findAll();
        return ResponseEntity.ok().body(allProducts);

    }
    @PostMapping
    public ResponseEntity<ProductCategory> save(@RequestBody ProductCategory productCategory){
       Optional<ProductCategory>category=categoryService.save(productCategory);
       return ResponseEntity.ok().body(category.get());
    }
}
