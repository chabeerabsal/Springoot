package com.example.ProductEntity.Service;

import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByid(int userID) {
        return userRepository.findById(userID);
    }
}
