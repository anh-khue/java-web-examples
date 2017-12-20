package com.khuetla.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author : Anh Khue
 */

@Controller
public class MessageController {

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        String message = "Welcome to Spring Boot!";
        model.addAttribute("message", message);
        return "welcome";
    }

    @PostMapping("/hello")
    public String hello(String name, Model model) {
        String message = "Hello, " + name;
        model.addAttribute("message", message);
        return "hello";
    }
}
