package com.example.ProductEntity.Controller;

import com.example.ProductEntity.DTO.AddtoCartDTO;
import com.example.ProductEntity.DTO.CartResponseDTO;
import com.example.ProductEntity.Modellor.Cart;
import com.example.ProductEntity.Modellor.User;
import com.example.ProductEntity.Repository.CardRepo;
import com.example.ProductEntity.Repository.UserRepository;
import com.example.ProductEntity.Service.CartService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepo  cartRepository;



    @Autowired
    private CartService cartService;
    @PostMapping("/{userID}/add")
    public ResponseEntity<?> addToCart(@PathVariable int userID, @RequestBody AddtoCartDTO addtoCartDTO){
        Optional<User> user=userService.findByid(userID);
        if(user.isPresent()){
        CartResponseDTO response= cartService.addToCart(user.get(),addtoCartDTO);
        return ResponseEntity.ok().body(response);
    }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/{userId}/cart")
    public Optional<Cart> getCart(@PathVariable Integer  userId) {

        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {

            Optional<Cart> cart = cartRepository.findByUser(user.get());

            return cart;
        }

        return Optional.empty();
    }
}
