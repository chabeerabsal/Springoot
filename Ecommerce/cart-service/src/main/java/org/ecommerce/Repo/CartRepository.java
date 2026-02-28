package org.ecommerce.Repo;

import org.ecommerce.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    List<Cart> findByUserId(UUID userId);
}
