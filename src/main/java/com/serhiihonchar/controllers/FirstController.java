package com.serhiihonchar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api")
public class FirstController {

    //    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Hello " + name + " " + surname + " !");
//        return "first/hello";
//    }
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
//        System.out.println("Hello, " + name + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name + " " + surname + "!");
        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                if (b != 0) {
                    result = a / (double) b;// 1/2=0.5
                } else {
                    throw new IllegalArgumentException("b must not to be a zero");
                }
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                model.addAttribute("error","You enter the wrong action! Try " + "multiplication" + " or " +
                        "division" + " or" + " subtraction" + " or" + " addition !");
                break;
        }
        model.addAttribute("result", result);

        return "first/calculator";
    }
}
