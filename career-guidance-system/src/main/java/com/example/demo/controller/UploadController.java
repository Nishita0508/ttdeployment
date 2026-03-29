package com.example.demo.controller;

import com.example.demo.model.Career;
import com.example.demo.model.Certification;
import com.example.demo.service.CareerService;
import com.example.demo.service.CertificationService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/career")
public class UploadController {

    private final CertificationService certificationService;
    private final CareerService careerService;

    public UploadController(CertificationService certificationService, CareerService careerService) {
        this.certificationService = certificationService;
        this.careerService = careerService;
    }

    @PostMapping("/upload-certificate")
    public GuidanceResponse uploadCertificate(@RequestParam("file") MultipartFile file) throws IOException, TesseractException {
        String text = certificationService.extractText(file);

        List<Certification> matchedCerts = certificationService.matchCertifications(text);
        List<Career> careers = careerService.getCareersByCertifications(matchedCerts);

        if(careers.isEmpty()) {
            careers = careerService.matchUnknownCertificate(text);
        }

        return new GuidanceResponse(matchedCerts, careers);
    }

    @PostMapping("/chat")
    public List<Career> chatQuery(@RequestBody String userMessage) {
        return careerService.matchUnknownCertificate(userMessage);
    }

    public record GuidanceResponse(List<Certification> certifications, List<Career> careers) {}
}