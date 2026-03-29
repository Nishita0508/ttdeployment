package com.example.demo.controller;

import com.example.demo.service.CareerScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/career-score")
@CrossOrigin("*")
public class CareerScoreController {

    private final CareerScoreService service;

    public CareerScoreController(CareerScoreService service){
        this.service = service;
    }

    @PostMapping
    public Map<String,Integer> calculateScore(@RequestBody List<String> skills){

        return service.calculateCareerScore(skills);
    }
}