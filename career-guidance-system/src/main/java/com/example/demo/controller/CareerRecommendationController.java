package com.example.demo.controller;

import com.example.demo.service.CareerRecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin("*")
public class CareerRecommendationController {

    private final CareerRecommendationService service;

    public CareerRecommendationController(CareerRecommendationService service){
        this.service = service;
    }

    @PostMapping("/recommend")
    public List<String> recommend(@RequestBody List<String> certifications){

        return service.recommendCareers(certifications);
    }
}