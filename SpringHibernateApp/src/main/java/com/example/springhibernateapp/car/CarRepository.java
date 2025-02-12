package com.example.springhibernateapp.car;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarsByColor(Color color);
    List<Car> findCarsByColorAndMark(Color color, String mark);

    @Query(value = "Select * from cars c where c.model = :model", nativeQuery = true)
    List<Car> findCarsByModelMyImpl(@Param("model") String model);
}
