package com.example.SearchingFilterSortingpagination.Controller;

import com.example.SearchingFilterSortingpagination.Model.Products;


import com.example.SearchingFilterSortingpagination.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class Controller {
    @Autowired
    ProductsService productsService;

    @GetMapping
    public ResponseEntity<Page<Products>> SearchProducts(@RequestParam(required = false) String keyword,
                                                         @RequestParam(required = false) String category,
                                                         @RequestParam(required = false) String brand,
                                                         @RequestParam(defaultValue = "0") int start,
                                                         @RequestParam(defaultValue = "5") int size) {
        Page<Products> allElements= productsService.getAllmatchedElements(keyword,category,brand,start,size);
        return ResponseEntity.ok(allElements);
    }

    @PostMapping
    public ResponseEntity<Products> AddProducts(@RequestBody Products products) {
        productsService.postProducts(products);
        return ResponseEntity.ok(products);
    }
}
