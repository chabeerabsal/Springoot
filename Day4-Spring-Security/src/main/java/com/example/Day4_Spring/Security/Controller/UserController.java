package com.example.Day4_Spring.Security.Controller;

import com.example.Day4_Spring.Security.Modellor.AppUser;
import com.example.Day4_Spring.Security.Repository.UserRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepoJPA userRepoJPA;

    @PostMapping("/Register")
    public String Register(@RequestBody AppUser user){
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER"); // default role
        }

        user.setPassword("{noop}" + user.getPassword());

        userRepoJPA.save(user);
        return "Registered Successfully";
    }


}
