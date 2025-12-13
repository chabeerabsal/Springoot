package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepo extends CrudRepository<Cart,Integer> {
    Optional<Cart> findByuser(User user);
}
