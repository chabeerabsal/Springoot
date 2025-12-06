package com.example.ProductEntity.Modellor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="productCategory",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonManagedReference
    List<Products> products;


}
