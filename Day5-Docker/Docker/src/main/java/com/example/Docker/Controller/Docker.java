package com.example.Docker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Docker {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

}
