package com.example.csv_formatter_mongo_db_app.repository;


import com.example.csv_formatter_mongo_db_app.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
