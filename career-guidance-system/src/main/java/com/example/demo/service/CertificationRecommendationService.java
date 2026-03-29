package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CertificationRecommendationService {

    public List<String> recommendCertifications(String career){

        career = career.toLowerCase();

        Map<String,List<String>> certifications = new HashMap<>();

        certifications.put("frontend developer",
                Arrays.asList(
                        "Meta Frontend Developer",
                        "Google UX Design",
                        "JavaScript Algorithms Certification"
                ));

        certifications.put("backend developer",
                Arrays.asList(
                        "Oracle Java Certification",
                        "Spring Professional Certification",
                        "Node.js Certification"
                ));

        certifications.put("data scientist",
                Arrays.asList(
                        "IBM Data Science Professional Certificate",
                        "Google Data Analytics",
                        "TensorFlow Developer Certification"
                ));

        certifications.put("cloud engineer",
                Arrays.asList(
                        "AWS Solutions Architect",
                        "Microsoft Azure Administrator",
                        "Google Cloud Associate Engineer"
                ));

        certifications.put("cybersecurity",
                Arrays.asList(
                        "CompTIA Security+",
                        "Certified Ethical Hacker",
                        "Cisco CyberOps Associate"
                ));

        return certifications.getOrDefault(
                career,
                List.of("No certifications found for this career")
        );
    }
    public List<String> recommendNextCertifications(List<String> certifications){

        List<String> recommendations = new ArrayList<>();

        for(String cert : certifications){

            cert = cert.toLowerCase();

            if(cert.contains("html") || cert.contains("css") || cert.contains("javascript")){
                recommendations.add("React Certification");
                recommendations.add("Advanced JavaScript Certification");
                recommendations.add("Meta Frontend Developer");
            }

            if(cert.contains("python")){
                recommendations.add("Machine Learning Certification");
                recommendations.add("TensorFlow Developer Certification");
            }

            if(cert.contains("aws") || cert.contains("cloud")){
                recommendations.add("AWS Solutions Architect");
                recommendations.add("Docker Certification");
                recommendations.add("Kubernetes Certification");
            }

            if(cert.contains("network")){
                recommendations.add("CCNA");
                recommendations.add("CompTIA Security+");
            }
        }

        return recommendations;
    }
}