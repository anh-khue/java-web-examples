package com.khuetla.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Anh Khue
 */

@Controller
public class ViewController {

    @GetMapping({"/", "/movies-page"})
    public String movie() {
        return "movies";
    }
}
