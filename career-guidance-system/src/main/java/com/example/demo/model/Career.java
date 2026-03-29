package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String domain;      // Software, Civil, Mechanical, Higher Studies, Projects
    private String branch;      // CSE, AI, AIML, Civil, Mechanical, All Branches
    private String description; // Job role

    @ElementCollection
    private List<String> requiredCertifications;

    private String roadmapLink; // Link to roadmap.sh

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getRequiredCertifications() { return requiredCertifications; }
    public void setRequiredCertifications(List<String> requiredCertifications) { this.requiredCertifications = requiredCertifications; }
    public String getRoadmapLink() { return roadmapLink; }
    public void setRoadmapLink(String roadmapLink) { this.roadmapLink = roadmapLink; }
}