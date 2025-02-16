package com.example.weatherApiAppR2dbc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherApiResponse {

    @JsonProperty("data")
    private List<WeatherCardDto> data;
}
