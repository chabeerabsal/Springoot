package com.example.Day4_Spring.Security.Repository;

import com.example.Day4_Spring.Security.Modellor.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoJPA extends JpaRepository<AppUser,Integer> {

        AppUser findByUsername(String username);
}
