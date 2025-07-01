package com.example.Day2_SpringdataJPA.Controller;

import com.example.Day2_SpringdataJPA.Modellor.User;
import com.example.Day2_SpringdataJPA.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")

public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> getALLuser()
    {
        return userRepository.findAll();
    }
    @PostMapping
    public User save(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User updateduser)

    {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setName(updateduser.getName());
            user.setAge(updateduser.getAge());
            user.setEmail(updateduser.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Deleted";
    }

}
