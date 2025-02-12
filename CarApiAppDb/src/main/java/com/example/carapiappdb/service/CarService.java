package com.example.carapiappdb.service;


import com.example.carapiappdb.client.CarNewsClient;
import com.example.carapiappdb.database.CarDao;
import com.example.carapiappdb.domain.Car;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.*;


@Service
@RequiredArgsConstructor
public class CarService implements CarDao {

    private List<Car> carList = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    private final CarNewsClient carNewsClient;


    @Override
    public List<Car> findAll(LocalDate startDate, LocalDate endDate) {
        List<Car> cars = new ArrayList<>();
        String sql = "Select * From CARS";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream()
                .filter(
                        element -> {
                            LocalDate dataProd = LocalDate.parse(String.valueOf(element.get("data_produced")));

                            return dataProd.getYear() >= startDate.getYear() && dataProd.getYear() <= endDate.getYear();
                        }).
                forEach(element ->
                        cars.add(new Car(
                                Long.parseLong(String.valueOf(element.get("car_id"))),
                                String.valueOf(element.get("car_brand")),
                                String.valueOf(element.get("car_model")),
                                String.valueOf(element.get("car_color")),
                                LocalDate.parse(String.valueOf(element.get("data_produced")))
                        )));
        return cars;
    }

    @Override
    public Car addCar(Car car) {

        String sql = "INSERT INTO CARS (car_brand, car_model, car_color, data_produced) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getBrand(), car.getModel(), car.getColor(), car.getDateProduced());
        return car;
    }

    @Override
    public Mono<List<String>> getCarNews() {
        return carNewsClient.getCarNews();
    }

    public void saveNewsToDb() {
        Mono<List<String>> news = carNewsClient.getCarNews();
        String sql = "INSERT INTO NEWS (description) VALUES (?)";
        news.subscribe(
                newsList -> newsList.forEach(newsItem -> jdbcTemplate.update(sql, newsItem))
        );
    }

    @Override
    public void updateNews(Long id, String description) {
        String sql = "UPDATE NEWS SET description = ? WHERE news_id = ?";
        jdbcTemplate.update(sql, description, id);

    }

    @Override
    public List<Map<String, Object>> getNewsFromDb() {
        String sql = "SELECT news_id, description FROM NEWS";
        return jdbcTemplate.queryForList(sql);
    }
}



