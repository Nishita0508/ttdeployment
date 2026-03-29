package com.example.demo.service;

import com.example.demo.model.Career;
import com.example.demo.model.Certification;
import com.example.demo.repository.CareerRepository;
import com.example.demo.repository.CertificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CertificationRepository certificationRepository;
    private final CareerRepository careerRepository;

    public DataLoader(CertificationRepository certificationRepository, CareerRepository careerRepository) {
        this.certificationRepository = certificationRepository;
        this.careerRepository = careerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // ===== Certifications =====
        Certification cert1 = new Certification();
        cert1.setName("Computer Networking");
        cert1.setDescription("Networking concepts and protocols");
        certificationRepository.save(cert1);

        Certification cert2 = new Certification();
        cert2.setName("Machine Learning");
        cert2.setDescription("ML concepts and applications");
        certificationRepository.save(cert2);

        Certification cert3 = new Certification();
        cert3.setName("AI");
        cert3.setDescription("Artificial Intelligence concepts");
        certificationRepository.save(cert3);

        Certification cert4 = new Certification();
        cert4.setName("Cloud");
        cert4.setDescription("Cloud Computing and DevOps");
        certificationRepository.save(cert4);

        Certification cert5 = new Certification();
        cert5.setName("Python");
        cert5.setDescription("Python Programming");
        certificationRepository.save(cert5);

        // Add more certifications here as needed
        Certification cert6 = new Certification();
        cert6.setName("Java");
        cert6.setDescription("Java Programming");
        certificationRepository.save(cert6);

        Certification cert7 = new Certification();
        cert7.setName("React");
        cert7.setDescription("Frontend Development");
        certificationRepository.save(cert7);

        Certification cert8 = new Certification();
        cert8.setName("Docker");
        cert8.setDescription("Containerization technology");
        certificationRepository.save(cert8);

        Certification cert9 = new Certification();
        cert9.setName("Kubernetes");
        cert9.setDescription("Container orchestration");
        certificationRepository.save(cert9);

        Certification cert10 = new Certification();
        cert10.setName("Cybersecurity");
        cert10.setDescription("Security fundamentals");
        certificationRepository.save(cert10);

        // ===== Careers =====
        Career career1 = new Career();
        career1.setDomain("Software");
        career1.setBranch("CSE/Networking");
        career1.setDescription("Network Engineer");
        career1.setRoadmapLink("https://roadmap.sh/networking");
        careerRepository.save(career1);

        Career career2 = new Career();
        career2.setDomain("Software");
        career2.setBranch("CSE/AI");
        career2.setDescription("AI / ML Engineer");
        career2.setRoadmapLink("https://roadmap.sh/data-science");
        careerRepository.save(career2);

        Career career3 = new Career();
        career3.setDomain("Software");
        career3.setBranch("CSE");
        career3.setDescription("Python Developer");
        career3.setRoadmapLink("https://roadmap.sh/python");
        careerRepository.save(career3);

        Career career4 = new Career();
        career4.setDomain("Software");
        career4.setBranch("CSE");
        career4.setDescription("Cloud Engineer");
        career4.setRoadmapLink("https://roadmap.sh/cloud");
        careerRepository.save(career4);

        Career career5 = new Career();
        career5.setDomain("Higher Studies");
        career5.setBranch("All Branches");
        career5.setDescription("M.Tech / Research Scholar");
        career5.setRoadmapLink("https://roadmap.sh");
        careerRepository.save(career5);

        Career career6 = new Career();
        career6.setDomain("Mechanical");
        career6.setBranch("Mechanical");
        career6.setDescription("Product Designer / Manufacturing Engineer");
        career6.setRoadmapLink("https://roadmap.sh");
        careerRepository.save(career6);

        Career career7 = new Career();
        career7.setDomain("Civil");
        career7.setBranch("Civil");
        career7.setDescription("Structural Engineer / Civil Draftsman");
        career7.setRoadmapLink("https://roadmap.sh");
        careerRepository.save(career7);

        Career career8 = new Career();
        career8.setDomain("Projects");
        career8.setBranch("All Branches");
        career8.setDescription("Project Showcase / Portfolio");
        career8.setRoadmapLink("https://roadmap.sh");
        careerRepository.save(career8);
    }
}