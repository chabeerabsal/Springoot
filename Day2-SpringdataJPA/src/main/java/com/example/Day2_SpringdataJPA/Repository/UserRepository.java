package com.example.Day2_SpringdataJPA.Repository;

import com.example.Day2_SpringdataJPA.Modellor.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
