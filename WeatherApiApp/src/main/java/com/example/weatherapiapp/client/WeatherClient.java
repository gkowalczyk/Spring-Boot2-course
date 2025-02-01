package com.example.weatherapiapp.client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class WeatherClient {

    private final WebClient webClient;
    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${api.app.key}")
    private String apiAppKey;


    public Mono<String> getWeather(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(weatherApiEndpoint)
                        .queryParam("key", apiAppKey)
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> {
                    log.error(e.getMessage(), e);
                    return Mono.just("Error while fetching weather data. Please try again later.");
                });
    }
}
