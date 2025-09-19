package com.example.Cache.Repository;

import com.example.Cache.Modellor.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAU extends JpaRepository<User,Integer> {

}
