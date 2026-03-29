package com.example.demo.controller;

import com.example.demo.service.CertificationAnalyzerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analyzer")
@CrossOrigin("*")
public class CertificationAnalyzerController {

    private final CertificationAnalyzerService service;

    public CertificationAnalyzerController(CertificationAnalyzerService service){
        this.service = service;
    }

    @PostMapping
    public Map<String,Object> analyze(@RequestBody List<String> certifications){

        return service.analyze(certifications);
    }
}