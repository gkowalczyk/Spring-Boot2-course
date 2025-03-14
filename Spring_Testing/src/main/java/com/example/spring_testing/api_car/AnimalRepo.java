package com.example.spring_testing.api_car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
}
