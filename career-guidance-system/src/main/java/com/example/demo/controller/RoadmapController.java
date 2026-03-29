package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {

    @GetMapping("/{career}")
    public List<String> getRoadmap(@PathVariable String career){

        if(career.equalsIgnoreCase("Cloud Engineer")){
            return List.of(
                    "AWS Cloud Practitioner",
                    "AWS Solutions Architect Associate",
                    "AWS Solutions Architect Professional"
            );
        }

        if(career.equalsIgnoreCase("Network Engineer")){
            return List.of(
                    "CompTIA Network+",
                    "Cisco CCNA",
                    "Cisco CCNP"
            );
        }

        return List.of("No roadmap available");
    }
}
