package com.example.weatherApiAppR2dbc.repository;

import com.example.weatherApiAppR2dbc.model.WeatherCard;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends R2dbcRepository<WeatherCard, Long> {
}
