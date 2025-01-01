package com.example.webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.ReactiveMongoRepositoryConfigurationExtension;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
}
