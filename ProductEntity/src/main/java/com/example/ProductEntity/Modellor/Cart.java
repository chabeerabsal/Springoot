package com.example.ProductEntity.Modellor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property="id"
)
public class Cart {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name="users",referencedColumnName = "id")
    private User user;

    @OneToMany()
    private List<CartItems> cardItems;
}
