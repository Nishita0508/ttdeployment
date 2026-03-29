package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CertificationAnalyzerService {

    public Map<String,Object> analyze(List<String> certifications){

        List<String> careers = new ArrayList<>();

        for(String cert : certifications){

            cert = cert.toLowerCase();

            if(cert.contains("aws")){
                careers.add("Cloud Engineer");
            }

            if(cert.contains("python")){
                careers.add("Data Scientist");
            }

            if(cert.contains("html")){
                careers.add("Frontend Developer");
            }

            if(cert.contains("network")){
                careers.add("Network Engineer");
            }

        }

        Map<String,Object> result = new HashMap<>();
        result.put("certifications",certifications);
        result.put("suggestedCareers",careers);

        return result;
    }
}