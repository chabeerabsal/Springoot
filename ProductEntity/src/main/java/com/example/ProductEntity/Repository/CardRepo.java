package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CardRepo extends CrudRepository<Cart,Integer> {
}
