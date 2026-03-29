package com.example.demo.controller;

import com.example.demo.model.Certification;
import com.example.demo.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin("*")
public class CertificationController {

    @Autowired
    private CertificationService service;

    // GET all certifications
    @GetMapping
    public List<Certification> getAllCertifications() {
        return service.getAllCertifications();
    }

    // POST a new certification
    @PostMapping
    public Certification addCertification(@RequestBody Certification certification) {
        return service.saveCertification(certification); // now works!
    }
}