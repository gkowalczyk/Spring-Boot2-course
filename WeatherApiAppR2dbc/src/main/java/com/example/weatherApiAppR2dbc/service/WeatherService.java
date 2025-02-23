package com.example.weatherApiAppR2dbc.service;

import com.example.weatherApiAppR2dbc.mapper.WeatherMapper;
import com.example.weatherApiAppR2dbc.modelDto.WeatherApiResponse;
import com.example.weatherApiAppR2dbc.modelDto.WeatherCardDto;
import com.example.weatherApiAppR2dbc.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WebClient webClient;
    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${api.app.key}")
    private String apiAppKey;
    private final WeatherMapper weatherMapper;
    private final WeatherRepository weatherRepository;
    private final CityHolder cityHolder;


    public Mono<WeatherCardDto> getWeather(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(weatherApiEndpoint)
                        .queryParam("key", apiAppKey)
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .flatMap(response -> response.getData().isEmpty()
                        ? Mono.empty()
                        : Mono.just((response.getData().get(0))))
                .onErrorResume(WebClientResponseException.class, e -> {
                    log.error("Błąd przy pobieraniu danych pogodowych: Status {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
                    return Mono.empty();
                });
    }

    @Async
    @Scheduled(cron = "*/5 * * * * *")
  //  @Scheduled(cron = "0 0 * * * *")
    public void saveWeatherToDb() {
        getWeather(cityHolder.getCity())
                .map(weatherMapper::toEntity)
                .flatMap(weatherRepository::save)
                .doOnSuccess(weatherCard -> log.info("Zapisano do bazy danych: {}", weatherCard))
                .doOnError(error -> log.error("Błąd przy zapisie do bazy danych: {}", error.getMessage()))
                .subscribe();
    }
}
