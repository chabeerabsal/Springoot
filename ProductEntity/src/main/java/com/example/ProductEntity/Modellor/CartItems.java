package com.example.ProductEntity.Modellor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;



@Entity
@JsonIdentityInfo(
        generator= ObjectIdGenerators.PropertyGenerator.class,
        property="id"
)
public class CartItems {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="Cart",referencedColumnName="id")
    private Cart cart;

    @ManyToOne()
    @JoinColumn(name="ProductId",referencedColumnName = "id")
    private Products products;

    private int quantity;
}
