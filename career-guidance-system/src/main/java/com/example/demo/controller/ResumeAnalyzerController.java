package com.example.demo.controller;

import com.example.demo.service.ResumeAnalyzerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeAnalyzerController {

    private final ResumeAnalyzerService service;

    public ResumeAnalyzerController(ResumeAnalyzerService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public Map<String,Object> analyzeResume(@RequestParam("file") MultipartFile file) {

        return service.analyzeResume(file);
    }
}