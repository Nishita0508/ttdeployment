package com.example.demo.service;

import com.example.demo.model.Career;
import com.example.demo.model.Certification;
import com.example.demo.repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    // Matches careers based on certifications
    public List<Career> getCareersByCertifications(List<Certification> certifications) {
        List<Career> result = new ArrayList<>();
        for (Certification cert : certifications) {
            result.addAll(careerRepository.findByDescriptionContainingIgnoreCase(cert.getName()));
        }
        return result;
    }

    // Matches unknown certificates by keywords
    public List<Career> matchUnknownCertificate(String text) {
        List<Career> result = new ArrayList<>();
        text = text.toLowerCase();

        if (text.contains("network")) {
            result.addAll(careerRepository.findByDescriptionContainingIgnoreCase("Network"));
        }
        if (text.contains("python")) {
            result.addAll(careerRepository.findByDescriptionContainingIgnoreCase("Python"));
        }
        if (text.contains("ml") || text.contains("machine learning") || text.contains("ai")) {
            result.addAll(careerRepository.findByDescriptionContainingIgnoreCase("AI"));
        }
        if (text.contains("cloud")) {
            result.addAll(careerRepository.findByDescriptionContainingIgnoreCase("Cloud"));
        }
        // Add more keyword checks as needed

        return result;
    }
}