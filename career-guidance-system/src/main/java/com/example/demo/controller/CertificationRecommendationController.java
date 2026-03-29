package com.example.demo.controller;

import com.example.demo.service.CertificationRecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications/recommend")
@CrossOrigin("*")
public class CertificationRecommendationController {

    private final CertificationRecommendationService service;

    public CertificationRecommendationController(CertificationRecommendationService service){
        this.service = service;
    }

    @GetMapping("/{career}")
    public List<String> recommend(@PathVariable String career){
        return service.recommendCertifications(career);
    }
    @PostMapping("/recommend-next")
    public List<String> recommendNext(@RequestBody List<String> certifications){
        return service.recommendNextCertifications(certifications);
    }
}