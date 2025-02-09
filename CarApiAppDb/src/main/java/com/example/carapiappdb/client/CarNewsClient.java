package com.example.carapiappdb.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class CarNewsClient {

    private final WebClient webClient;
    @Value("${car.api.endpoint.prod}")
    private String carApiEndpoint;
    @Value("${api.app.key}")
    private String apiKey;


    public Mono<List<String>> getCarNews() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("")
                        .queryParam("q", "samochody")
                        .queryParam("from", "2025-02-08")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(this::extractDataFromJson)
                .onErrorResume(WebClientResponseException.class, e -> {
                    log.error("Błąd przy pobieraniu news: Status {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
                    return Mono.just(new ArrayList<>());
                });
    }

    public Mono<List<String>> extractDataFromJson(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> descriptionList = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode articles = jsonNode.get("articles");
            articles.forEach(article -> {
                String description = article.get("description").asText();
                descriptionList.add(description);
            });
        } catch (Exception e) {
            log.error("Błąd przy przetwarzaniu odpowiedzi z serwisu: {}", e.getMessage());
        }
        return Mono.just(descriptionList);
    }
}
