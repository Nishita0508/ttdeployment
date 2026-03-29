package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SkillGapService {

    public List<String> analyze(String career){

        Map<String, List<String>> careerSkills = new HashMap<>();

        careerSkills.put("frontend developer",
                Arrays.asList("HTML","CSS","JavaScript","React","Git"));

        careerSkills.put("backend developer",
                Arrays.asList("Java","Spring Boot","SQL","REST API"));

        careerSkills.put("data scientist",
                Arrays.asList("Python","Machine Learning","Statistics","SQL"));

        careerSkills.put("cloud engineer",
                Arrays.asList("AWS","Docker","Kubernetes","Linux"));

        return careerSkills.getOrDefault(
                career.toLowerCase(),
                List.of("No data available")
        );
    }
}