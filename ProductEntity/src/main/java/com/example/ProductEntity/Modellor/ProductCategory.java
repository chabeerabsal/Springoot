package com.example.ProductEntity.Modellor;

import com.example.ProductEntity.DTO.CategoryDTO;
import com.fasterxml.jackson.annotation.*;
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
    @JsonIgnore
    List<Products> products= new ArrayList<>();
    public CategoryDTO setDTO()
    {
        return new CategoryDTO(this);
    }


}
