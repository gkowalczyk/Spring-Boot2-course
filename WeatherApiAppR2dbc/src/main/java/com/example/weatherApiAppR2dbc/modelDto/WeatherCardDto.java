package com.example.weatherApiAppR2dbc.modelDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherCardDto {

    @JsonProperty("city_name")
    private String city;
    @JsonProperty("temp")
    private Double temperature;
    @JsonProperty("ob_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
}