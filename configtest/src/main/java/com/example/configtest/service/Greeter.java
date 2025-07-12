package com.example.configtest.service;

public class Greeter {
    private final String message;
    private final String name;

    public Greeter(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String greet() {
        return message + " " + name + "!";
    }
}
