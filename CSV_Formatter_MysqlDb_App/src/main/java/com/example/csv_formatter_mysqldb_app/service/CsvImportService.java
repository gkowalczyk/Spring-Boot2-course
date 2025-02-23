package com.example.csv_formatter_mysqldb_app.service;

import com.example.csv_formatter_mysqldb_app.aspect.TimeCounterAspect;
import com.example.csv_formatter_mysqldb_app.model.Person;
import com.example.csv_formatter_mysqldb_app.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class CsvImportService {

    List<Person> persons = new ArrayList<>();
    @Value("${csv.file.path}")
    private String csvFilePath;
    private final DataBaseService dataBaseService;

    @EventListener(ApplicationReadyEvent.class)
    @TimeCounterAspect
    public void importCsv() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath))) {
            CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            csvParser.forEach(csvRecord -> {
                Person person = new Person();
                person.setFirstName(csvRecord.get("first_name"));
                person.setLastName(csvRecord.get("last_name"));
                person.setEmail(csvRecord.get("email"));
                person.setGender(csvRecord.get("gender"));
                person.setIpAddress(csvRecord.get("ip_address"));
                persons.add(person);
            });
            dataBaseService.saveAll(persons);

        } catch (IOException e) {
            e.printStackTrace();
                  }
    }
}
