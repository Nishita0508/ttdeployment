package com.example.demo.model;

import java.util.List;

public class CareerRecommendation {

    private List<String> careers;

    public CareerRecommendation(List<String> careers){
        this.careers = careers;
    }

    public List<String> getCareers(){
        return careers;
    }
}