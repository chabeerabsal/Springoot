package com.example.ProductEntity.Repository;

import com.example.ProductEntity.Modellor.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
