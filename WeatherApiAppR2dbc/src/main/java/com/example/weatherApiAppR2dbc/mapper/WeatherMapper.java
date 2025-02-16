package com.example.weatherApiAppR2dbc.mapper;

import com.example.weatherApiAppR2dbc.model.WeatherCard;
import com.example.weatherApiAppR2dbc.model.WeatherCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "temperature", target = "temperature")
    @Mapping(source = "date", target = "date")
    WeatherCard toEntity(WeatherCardDto weatherCardDto);
}