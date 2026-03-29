package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return authService.register(student);
    }

    @PostMapping("/login")
    public Student login(@RequestBody Student student) {
        return authService.login(student.getEmail(), student.getPassword());
    }
}