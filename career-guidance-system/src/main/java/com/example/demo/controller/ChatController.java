package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    @PostMapping
    public String chat(@RequestBody String message) {

        message = message.toLowerCase();

        if (message.contains("cloud")) {
            return """
Recommended Cloud Certifications:
- AWS Cloud Practitioner
- AWS Solutions Architect
- Microsoft Azure Fundamentals

Possible Careers:
Cloud Engineer
DevOps Engineer
""";
        }

        if (message.contains("python")) {
            return """
Python is useful for these careers:

- Python Developer
- Data Scientist
- AI Engineer
- Backend Developer
""";
        }

        if (message.contains("ai") || message.contains("machine learning")) {
            return """
To become an AI Engineer learn:

1. Python
2. Machine Learning
3. Deep Learning
4. TensorFlow / PyTorch
""";
        }

        if (message.contains("network")) {
            return """
Networking Careers:

- Network Engineer
- System Administrator
- Cloud Network Engineer

Recommended Certifications:
CCNA
CompTIA Network+
""";
        }
        if(message.contains("hi") || message.contains("hello")){
            return "Hello! I am your AI Career Guidance Assistant.";
        }

        if(message.contains("html")){
            return "HTML certification helps you become a Frontend Developer.";
        }

        if(message.contains("python")){
            return "Python certification can lead to Data Scientist roles.";
        }


        return "Ask about careers like cloud, python, AI, networking.";
    }
}