package com.example.demo.service;

import com.example.demo.model.Certification;
import com.example.demo.repository.CertificationRepository;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    // Extract text from uploaded file
    public String extractText(MultipartFile file) throws IOException, TesseractException {
        String content = "";
        String filename = file.getOriginalFilename().toLowerCase();

        if (filename.endsWith(".pdf")) {
            PDDocument document = PDDocument.load(file.getInputStream());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            content = pdfStripper.getText(document);
            document.close();
        } else {
            File tempFile = File.createTempFile("upload", filename);
            file.transferTo(tempFile);
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("tessdata"); // path to tessdata folder
            content = tesseract.doOCR(tempFile);
            tempFile.delete();
        }

        return content.toLowerCase().replaceAll("\\s",""); // remove spaces for flexible match
    }

    // Match extracted text with existing certifications
    public List<Certification> matchCertifications(String text) {
        List<Certification> matched = new ArrayList<>();
        for (Certification cert : certificationRepository.findAll()) {
            String certName = cert.getName().toLowerCase().replaceAll("\\s","");
            if (text.contains(certName)) {
                matched.add(cert);
            }
        }
        return matched;
    }

    // GET all certifications
    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    // SAVE a new certification
    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }
}