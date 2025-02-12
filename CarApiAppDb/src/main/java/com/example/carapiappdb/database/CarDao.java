package com.example.carapiappdb.database;

import com.example.carapiappdb.domain.Car;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface CarDao {
    List<Car> findAll(LocalDate dateFrom, LocalDate dateTo);

    Car addCar(Car car);

    Mono<List<String>> getCarNews();

    void updateNews(Long id, String description);

    List<Map<String, Object>> getNewsFromDb();
}
