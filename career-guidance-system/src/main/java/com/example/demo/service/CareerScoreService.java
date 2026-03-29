package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CareerScoreService {

    public Map<String,Integer> calculateCareerScore(List<String> skills){

        int frontendScore = 0;
        int cloudScore = 0;
        int dataScienceScore = 0;

        for(String skill : skills){

            skill = skill.toLowerCase();

            if(skill.contains("html") || skill.contains("css") || skill.contains("javascript"))
                frontendScore += 30;

            if(skill.contains("react"))
                frontendScore += 40;

            if(skill.contains("aws") || skill.contains("cloud"))
                cloudScore += 40;

            if(skill.contains("docker") || skill.contains("kubernetes"))
                cloudScore += 30;

            if(skill.contains("python"))
                dataScienceScore += 30;

            if(skill.contains("machine learning"))
                dataScienceScore += 40;

            if(skill.contains("sql"))
                dataScienceScore += 20;
        }

        Map<String,Integer> result = new HashMap<>();

        result.put("Frontend Developer", frontendScore);
        result.put("Cloud Engineer", cloudScore);
        result.put("Data Scientist", dataScienceScore);

        return result;
    }
}
