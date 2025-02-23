package com.example.weatherApiAppR2dbc.service;

import org.springframework.stereotype.Component;

@Component
public class CityHolder {

    private volatile String city = "Wroclaw";

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
