package com.example.OnetoOne.Controller;

import com.example.OnetoOne.Entity.User;
import com.example.OnetoOne.Repository.AddressNameRepo;
import com.example.OnetoOne.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public User createUser(@RequestBody User user)
    {
       return userRepo.save(user);
    }

    @GetMapping
    public List<User> findAll()
    {
        return userRepo.findAll();
    }


}
