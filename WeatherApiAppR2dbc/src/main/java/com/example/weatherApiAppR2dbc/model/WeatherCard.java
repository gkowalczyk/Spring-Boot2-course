package com.example.weatherApiAppR2dbc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("weather_data")
@Data
public class WeatherCard {

    @Id
    private Long id;
    private String city;
    private Double temperature;
    private LocalDateTime date;
}
