package com.example.demo.controller;

import com.example.demo.service.SkillGapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillgap")
@CrossOrigin("*")
public class SkillGapController {

    private final SkillGapService service;

    public SkillGapController(SkillGapService service){
        this.service = service;
    }

    @GetMapping("/{career}")
    public List<String> analyze(@PathVariable String career){

        return service.analyze(career);
    }
}