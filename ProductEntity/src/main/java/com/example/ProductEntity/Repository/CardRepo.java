package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByuser(User user);



    Optional<Cart> findByUser(User user);

    Cart findByUserId(Integer userId);

    //Optional<?> findBycart(Object o);
}
