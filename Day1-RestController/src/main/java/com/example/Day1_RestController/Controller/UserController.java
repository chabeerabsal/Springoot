package com.example.Day1_RestController.Controller;

import com.example.Day1_RestController.Modellor.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/Users"))
public class UserController {
    List<User> users=new ArrayList<>();
    @PostMapping
    public void addUser(@RequestBody User user)
    {
        users.add(user);
    }
    @GetMapping
    public List<User> getUsers()
    {
        return users;
    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id,@RequestBody User user)
    {
        for(User u:users){
        if(u.getId()==id)
        {
          u.setName(user.getName());
          u.setAge(user.getAge());
          break;
        }
    }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id)
    {
        for(User u:users){
            if(u.getId()==id)
            {
                users.remove(u);
                break;
            }
        }
       // users.remove(user);
    }
}
