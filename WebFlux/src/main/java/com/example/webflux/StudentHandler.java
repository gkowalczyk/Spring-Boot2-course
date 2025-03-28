package com.example.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
public class StudentHandler {

    public Mono<ServerResponse> serverResponseMono(ServerRequest serverRequest) {
        Flux<Student> studentFlux = Flux.just(
                new Student("Adam"),
                new Student("Ania"),
                new Student("Karol"));
        return ServerResponse
                .ok()
                .body(studentFlux, Student.class);
    }

   // @Bean
    public RouterFunction<ServerResponse> responseRouterFunction(StudentHandler studentHandler) {
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/students"), studentHandler::serverResponseMono);

    }
}
