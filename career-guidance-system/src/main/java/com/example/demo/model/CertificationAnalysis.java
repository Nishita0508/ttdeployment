package com.example.demo.model;

import java.util.List;

public class CertificationAnalysis {

    private String certification;
    private List<String> careers;
    private List<String> nextSkills;
    private String roadmap;

    public CertificationAnalysis(String certification, List<String> careers, List<String> nextSkills, String roadmap) {
        this.certification = certification;
        this.careers = careers;
        this.nextSkills = nextSkills;
        this.roadmap = roadmap;
    }

    public String getCertification() {
        return certification;
    }

    public List<String> getCareers() {
        return careers;
    }

    public List<String> getNextSkills() {
        return nextSkills;
    }

    public String getRoadmap() {
        return roadmap;
    }
}