package com.example.demo.model;

import java.util.List;

public class SkillGap {

    private List<String> missingSkills;

    public SkillGap(List<String> missingSkills){
        this.missingSkills = missingSkills;
    }

    public List<String> getMissingSkills(){
        return missingSkills;
    }
}