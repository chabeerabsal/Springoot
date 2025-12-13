package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<?> findBycart(User user);
    //Optional<?> findBycart(Object o);
}
