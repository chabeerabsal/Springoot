package com.example.Day1_RestController.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorld {

    @GetMapping("/hello")
    public String hello() {
        //System.out.println("hello");
        return "Hello World";
    }
}
