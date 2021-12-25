package com.serhiihonchar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hi")
    public String sayHello() {
        return "hello_world";
    }
}
