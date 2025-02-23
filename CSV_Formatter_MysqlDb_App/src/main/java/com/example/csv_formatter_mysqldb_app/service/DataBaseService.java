package com.example.csv_formatter_mysqldb_app.service;

import com.example.csv_formatter_mysqldb_app.aspect.TimeCounterAspect;
import com.example.csv_formatter_mysqldb_app.model.Person;
import com.example.csv_formatter_mysqldb_app.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataBaseService {

    private final PersonRepository personRepository;

   @Transactional(rollbackFor = Exception.class)
    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
        log.info("Persons saved to database");
       // throw new RuntimeException("Rollback"); to test rollback only
    }

    @EventListener(ApplicationReadyEvent.class)
    @TimeCounterAspect
    public void loadDatabase() {
        personRepository.findAll();
    }
}
