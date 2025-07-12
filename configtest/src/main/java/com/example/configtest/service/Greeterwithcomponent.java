package com.example.configtest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Greeterwithcomponent {

    @Value("${greeting.message}")
    private String message;

    @Value("${greeting.name}")
    private String name;

    public String greet() {
        return message + " " + name + "!";
    }
}
