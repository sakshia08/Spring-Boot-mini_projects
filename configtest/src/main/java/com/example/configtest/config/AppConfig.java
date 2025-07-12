package com.example.configtest.config;

import com.example.configtest.service.Greeter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${greeting.message}")
    private String message;

    @Value("${greeting.name}")
    private String name;

    @Bean
    public Greeter greeter() {
        return new Greeter(message, name);
    }
}
