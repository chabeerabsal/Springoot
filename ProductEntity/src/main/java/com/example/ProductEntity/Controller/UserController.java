package com.example.ProductEntity.Controller;

import com.example.ProductEntity.DTO.AddtoCartDTO;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.UserRepository;
import com.example.ProductEntity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().build();

    }
}
