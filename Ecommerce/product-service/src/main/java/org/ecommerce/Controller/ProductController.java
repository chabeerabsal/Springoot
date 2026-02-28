package org.ecommerce.product.controller;

import lombok.RequiredArgsConstructor;

import org.ecommerce.Dto.ProductDto;
import org.ecommerce.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.ecommerce.Constants.ProductConstants.BASE_PATH;
import static org.ecommerce.Constants.ProductConstants.GET_BY_ID;


@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        return new ResponseEntity<>(productService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<ProductDto> get(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.getById(id));
    }
}