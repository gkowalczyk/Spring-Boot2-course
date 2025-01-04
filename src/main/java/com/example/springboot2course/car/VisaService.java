package com.example.springboot2course.car;

import org.springframework.stereotype.Service;

@Service
public class VisaService implements Card {

    public VisaService() {
    }

    @Override
    public String getInformation() {
        return "VisaService: This is a VisaService.";
    }
}
