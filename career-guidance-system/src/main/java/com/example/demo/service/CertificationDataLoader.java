package com.example.demo.service;

import com.example.demo.model.Certification;
import com.example.demo.repository.CertificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CertificationDataLoader implements CommandLineRunner {

    private final CertificationRepository certificationRepository;

    public CertificationDataLoader(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    @Override
    public void run(String... args) {
        Certification cert1 = new Certification();
        cert1.setName("Python");
        cert1.setDescription("Python programming certificate");
        certificationRepository.save(cert1);

        Certification cert2 = new Certification();
        cert2.setName("AWS");
        cert2.setDescription("AWS Cloud Certification");
        certificationRepository.save(cert2);

        Certification cert3 = new Certification();
        cert3.setName("Java");
        cert3.setDescription("Java programming certificate");
        certificationRepository.save(cert3);

        Certification cert4 = new Certification();
        cert4.setName("Networking");
        cert4.setDescription("Computer Networking certificate");
        certificationRepository.save(cert4);

        Certification cert5 = new Certification();
        cert5.setName("Data Science");
        cert5.setDescription("Data Science / AI certification");
        certificationRepository.save(cert5);

        Certification cert6 = new Certification();
        cert6.setName("Machine Learning");
        cert6.setDescription("Machine Learning / AI certification");
        certificationRepository.save(cert6);

        // Add more certifications as needed...
    }
}