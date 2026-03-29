package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/domains")
public class DomainController {

    @GetMapping
    public List<String> getDomains() {
        return List.of(
                "Software Development",
                "Cloud Computing",
                "Networking",
                "Cybersecurity",
                "Hardware Engineering"
        );
    }
}