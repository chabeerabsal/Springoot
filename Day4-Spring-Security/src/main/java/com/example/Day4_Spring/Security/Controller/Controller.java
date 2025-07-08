package com.example.Day4_Spring.Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/secure")
    public String secure(){
        return "This is secured webside";
    }
    @GetMapping("/user")
    public String user(){
        return "This is user webside";
    }
    @GetMapping("/admin")
    public String admin(){
        return "This is admin websidecd";
    }
}
