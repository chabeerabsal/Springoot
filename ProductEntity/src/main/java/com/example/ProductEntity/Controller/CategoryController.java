package com.example.ProductEntity.Controller;

import com.example.ProductEntity.DTO.CategoryDTO;
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
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAll(){
        List<ProductCategory> allProducts=productCategoryService.findAll();
        return ResponseEntity.ok().body(allProducts);

    }
    @GetMapping("/DTO/{Id}")
    public ResponseEntity<CategoryDTO> findCategories(@PathVariable Long Id){
        ProductCategory allProducts=productCategoryService.findById(Id);
        if(allProducts==null){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(allProducts.setDTO());
    }

    @PutMapping("/DTO/{Id}")
    public ResponseEntity<CategoryDTO> PutCategories(@PathVariable Long Id, @RequestBody ProductCategory productCategory){
        ProductCategory allProducts=productCategoryService.addCategoy(Id,productCategory);
        return ResponseEntity.ok().body(allProducts.setDTO());
    }

    @PostMapping
    public ResponseEntity<ProductCategory> save(@RequestBody ProductCategory productCategory){
       Optional<ProductCategory>category=productCategoryService.save(productCategory);

       return ResponseEntity.ok().body(category.get());
    }

    @DeleteMapping("{delete}")
    public ResponseEntity<String> delete(@PathVariable Long delete){
     productCategoryService.deleteProducts(delete);
     return ResponseEntity.ok().body("deleted");
    }

//    @DeleteMapping("/Orphan/{id}")
//    public ResponseEntity<String> deleteOrphan(@PathVariable Long id){
//        productCategoryService.deleteProducts(id);
//        return ResponseEntity.ok().body("deleted");
//
//    }
}
