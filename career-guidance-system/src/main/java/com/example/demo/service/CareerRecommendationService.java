package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CareerRecommendationService {

    public List<String> recommendCareers(List<String> certifications){

        List<String> careers = new ArrayList<>();

        for(String cert : certifications){

            cert = cert.toLowerCase();

            if(cert.contains("aws") || cert.contains("cloud")){
                careers.add("Cloud Engineer");
                careers.add("DevOps Engineer");
            }

            if(cert.contains("python")){
                careers.add("Data Scientist");
                careers.add("AI Engineer");
            }

            if(cert.contains("html") || cert.contains("frontend")){
                careers.add("Frontend Developer");
            }

            if(cert.contains("network")){
                careers.add("Network Engineer");
            }

        }

        return careers;
    }
}