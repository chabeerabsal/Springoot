package com.example.ProductEntity.Modellor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Data
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
    @JsonBackReference
    ProductCategory productCategory;


}
