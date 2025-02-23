package com.example.weatherApiAppR2dbc.mapper;

import com.example.weatherApiAppR2dbc.model.WeatherCard;
import com.example.weatherApiAppR2dbc.modelDto.WeatherCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    WeatherCard toEntity(WeatherCardDto weatherCardDto);
}