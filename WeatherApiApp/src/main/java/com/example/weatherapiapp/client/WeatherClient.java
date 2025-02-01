package com.example.weatherapiapp.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
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
                .onErrorResume(WebClientResponseException.class, e -> {
                    log.error("Błąd przy pobieraniu danych pogodowych: Status {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
                    return Mono.just("Serwis pogodowy jest chwilowo niedostępny. Spróbuj ponownie później.");
                });
    }
}
