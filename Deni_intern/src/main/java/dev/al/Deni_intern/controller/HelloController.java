package dev.al.Deni_intern.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class HelloController {
    @GetMapping("/hello")

    public String hello(){
        return "Hello Internship";
    }

    @PostMapping("/greet")
    public String greet (@RequestParam String language) {
        switch (language) {
            case "en":
                return "Hello Internship";
            case "sq":
                return "Pershendetje Internship";
            case "es":
                return "Hola Internship";
            default:
                return "Language not supported";
        }
    }
}