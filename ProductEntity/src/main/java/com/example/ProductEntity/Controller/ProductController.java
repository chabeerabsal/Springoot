package com.example.ProductEntity.Controller;

import com.example.ProductEntity.Modellor.ProductCategory;
import com.example.ProductEntity.Modellor.Products;
import com.example.ProductEntity.Repository.ProductCategoryRepository;
import com.example.ProductEntity.Service.ProductCategoryService;
import com.example.ProductEntity.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Products")
public class ProductController {

    private ProductService  productService;
    private ProductCategoryService productCategoryService;

   public  ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }


    @GetMapping()
    public ResponseEntity<?> getProducts() {
        List<Products> products=productService.findAll();
        return ResponseEntity.ok().body(products);
    }
    @PostMapping("{id}")
    public ResponseEntity<?> postProducts(@PathVariable Long id,@RequestBody Products product) {

        ProductCategory productCategory=productCategoryService.find(id);
         productService.save(product,productCategory);
         return ResponseEntity.ok().body(product);
    }
    @PostMapping
    public ResponseEntity<?> postProducts(@RequestBody Products product) {
//        if(product.getProductCategory()==null){
//            return ResponseEntity.badRequest().body("category not found");
//
//        }
      ProductCategory productCategory= productCategoryService.find(product.getProductCategory().getId());

        if(productCategory==null){
            return ResponseEntity.badRequest().body("category not found");
        }
      productService.saveProduct(product);
      return ResponseEntity.ok().body(product);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getProducts(@RequestParam String search) {
       List<Products> products=productService.searchbyKeyword(search);
       return ResponseEntity.ok().body(products);
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getProducts(@RequestParam String sort, @RequestParam String sortdir) {
       productService.sortMethod(sort,sortdir);
    }

}
