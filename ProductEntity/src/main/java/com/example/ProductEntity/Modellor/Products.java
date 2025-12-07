package com.example.ProductEntity.Modellor;

import com.example.ProductEntity.DTO.CategoryDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Data
@JsonIdentityInfo(
    generator= ObjectIdGenerators.PropertyGenerator.class,
    property="id"
)
public class  Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String  productName;
    String productDescription;
    Double productPrice;
    Integer productQuantity;
     @ManyToOne
    @JoinColumn(name="produceCategory",referencedColumnName ="id")
    ProductCategory productCategory;




}
