package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

}
