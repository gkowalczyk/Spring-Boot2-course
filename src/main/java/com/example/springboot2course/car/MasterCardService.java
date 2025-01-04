package com.example.springboot2course.car;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MasterCardService implements Card {

    public MasterCardService() {
    }

    @Override
    public String getInformation() {
        return "MasterCardService: This is a MasterCardService.";
    }
}
