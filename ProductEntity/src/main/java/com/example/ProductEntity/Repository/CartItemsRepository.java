package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
    @Query("SELECT SUM(ci.quantity * p.productPrice) " +
            "FROM CartItems ci JOIN ci.products p " +
            "WHERE ci.cart.id = :cartId")
    Double getCartTotal(int cartId);
}
