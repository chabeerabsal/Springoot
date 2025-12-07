package com.example.ProductEntity.Modellor;

import com.example.ProductEntity.DTO.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator= ObjectIdGenerators.PropertyGenerator.class,
        property="id"
)
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="productCategory",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)

    List<Products> products= new ArrayList<>();
    public CategoryDTO setDTO()
    {
        return new CategoryDTO(this);
    }


}
