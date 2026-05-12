package com.example.smartlibrary.controller;

import com.example.smartlibrary.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("fullName") String fullName,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        authService.register(fullName, email, password);
        return "redirect:/login";
    }
}