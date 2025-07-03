package com.example.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingsWebController {

    @GetMapping("/page")
    public String greetingPage(@RequestParam(defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "greetings"; // maps to greeting.html
    }
}
