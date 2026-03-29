package com.example.demo.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ResumeAnalyzerService {

    public Map<String,Object> analyzeResume(MultipartFile file) {

        Map<String,Object> result = new HashMap<>();

        try {

            PDDocument document = PDDocument.load(file.getInputStream());
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document).toLowerCase();

            document.close();

            List<String> skills = new ArrayList<>();

            if(text.contains("python")) skills.add("Python");
            if(text.contains("java")) skills.add("Java");
            if(text.contains("html")) skills.add("HTML");
            if(text.contains("css")) skills.add("CSS");
            if(text.contains("javascript")) skills.add("JavaScript");
            if(text.contains("aws")) skills.add("AWS");
            if(text.contains("machine learning")) skills.add("Machine Learning");

            String career = "General Software Developer";

            if(text.contains("machine learning") || text.contains("python"))
                career = "Data Scientist";

            if(text.contains("aws") || text.contains("cloud"))
                career = "Cloud Engineer";

            if(text.contains("html") && text.contains("javascript"))
                career = "Frontend Developer";

            result.put("skillsDetected", skills);
            result.put("recommendedCareer", career);

        } catch(Exception e) {

            result.put("error", e.getMessage());

        }

        return result;
    }
}