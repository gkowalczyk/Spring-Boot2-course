package com.example.webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.ReactiveMongoRepositoryConfigurationExtension;
import reactor.core.publisher.Mono;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
    Mono<Student> findStudentByName(String surname);
}
