package com.example.beanfactory.runner;

import com.example.beanfactory.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    private final GreetingService service;

    public DemoRunner(GreetingService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {
        System.out.println(service.getPersonalGreeting("Sakshi"));
    }
}

