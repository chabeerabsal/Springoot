package com.example.SearchingFilterSortingpagination.Service;

import com.example.SearchingFilterSortingpagination.Model.Products;
import com.example.SearchingFilterSortingpagination.Repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    ProductsRepo productsRepo;
    public Page<Products> getAllmatchedElements(String keyword, String category, String brand,int start, int size) {
        Pageable pageable = PageRequest.of(start, size);
     //   Page<Products> allElements;
        if(keyword!=null&&!keyword.isEmpty())
        {
           return productsRepo.findResultsWithMatchedKeyword(keyword,pageable);
        }
        if (category != null && brand != null) {
            return productsRepo.findByCategoryIgnoreCaseAndBrandIgnoreCase(category, brand, pageable);
        }

        return productsRepo.findAll(pageable);

    }

    public String postProducts(Products products) {
        productsRepo.save(products);
        return "success";
    }
}
