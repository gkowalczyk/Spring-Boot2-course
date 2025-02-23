package com.example.springmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToyRepository extends MongoRepository<Toy, String>{
}