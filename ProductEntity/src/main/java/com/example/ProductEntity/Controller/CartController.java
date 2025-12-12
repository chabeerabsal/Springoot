package com.example.ProductEntity.Controller;

import com.example.ProductEntity.DTO.AddtoCartDTO;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class CartController {

    @Autowired
    private UserService userService;
    @PostMapping("/{userID}/add")
    public ResponseEntity<?> addToCart(@PathVariable int userID, @RequestBody AddtoCartDTO addtoCartDTO){
        Optional<User> user=userService.findByid(userID);
        if(user.isPresent()){

        return ResponseEntity.ok().build();
    }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
