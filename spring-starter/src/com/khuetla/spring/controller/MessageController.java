package com.khuetla.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Anh Khue
 */

@EnableWebMvc
@Controller
public class MessageController {

    @RequestMapping(value = {"/", "welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        String message = "Welcome to Spring!";
        model.addAttribute("message", message);
        return "welcome";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(String name, Model model) {
        String message = "Hello, " + name;
        model.addAttribute("message", message);
        return "hello";
    }
}
