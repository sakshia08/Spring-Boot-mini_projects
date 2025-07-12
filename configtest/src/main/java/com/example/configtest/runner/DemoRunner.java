package com.example.configtest.runner;

import com.example.configtest.service.Greeter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    private final Greeter greeter;

    public DemoRunner(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public void run(String... args) {
        System.out.println(greeter.greet());
    }
}

