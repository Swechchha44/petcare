package com.petcare.controller;

import com.petcare.service.AuthService;
import com.petcare.dto.RegisterRequest;
import com.petcare.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Constructor Injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ Register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully!";
    }

    // ✅ Login (JWT)
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // Public Test
    @GetMapping("/test")
    public String test() {
        return "Auth Controller Working!";
    }
}
