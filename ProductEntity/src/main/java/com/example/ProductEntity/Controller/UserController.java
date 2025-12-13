package com.example.ProductEntity.Controller;

import com.example.ProductEntity.DTO.AddtoCartDTO;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.UserRepository;
import com.example.ProductEntity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User users=userService.save(user);
        return ResponseEntity.ok().body(users);

    }
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> allUsers=userService.findAll();
        return ResponseEntity.ok().body(allUsers);
    }

}
