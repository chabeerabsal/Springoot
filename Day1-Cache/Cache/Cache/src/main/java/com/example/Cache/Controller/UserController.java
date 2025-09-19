package com.example.Cache.Controller;

import com.example.Cache.Modellor.User;
import com.example.Cache.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
       return userService.getUserBYID(id);
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.update(user,id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
}
