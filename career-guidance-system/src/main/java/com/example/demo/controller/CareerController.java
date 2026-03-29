package com.example.demo.controller;

import com.example.demo.model.Career;
import com.example.demo.repository.CareerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin("*") // allow frontend requests
public class CareerController {

    private final CareerRepository careerRepository;

    public CareerController(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    // GET all careers
    @GetMapping
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    // POST add a new career
    @PostMapping
    public Career addCareer(@RequestBody Career career) {
        return careerRepository.save(career);
    }

    // GET careers by domain
    @GetMapping("/domain/{domain}")
    public List<Career> getCareersByDomain(@PathVariable String domain) {
        return careerRepository.findByDomainIgnoreCase(domain);
    }

    // GET careers by domain and branch
    @GetMapping("/domain/{domain}/branch/{branch}")
    public List<Career> getCareersByDomainAndBranch(@PathVariable String domain,
                                                    @PathVariable String branch) {
        return careerRepository.findByDomainIgnoreCaseAndBranchIgnoreCase(domain, branch);
    }
}