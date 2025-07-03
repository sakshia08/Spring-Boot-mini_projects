package com.example.hellospring.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class GreetingRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/greet")
    public String greetUser(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/greet/{name}")
    public String greetUserPath(@PathVariable String name) {
        return "Hey " + name + ", welcome via path!";
    }
}
