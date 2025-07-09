package com.example.formbinder.controller;

import com.example.formbinder.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class UserController {
    // Customize the way Spring binds input JSON to Java object
    // This method runs before request binding to customize how fields are parsed
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) {
                // Parse incoming date string like "1990-01-01"
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
        });
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Return custom response
        String message = "User created: " + user.getName() + ", DOB: " + user.getDob();
        return ResponseEntity.ok(message);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "API is working!";
    }
}
