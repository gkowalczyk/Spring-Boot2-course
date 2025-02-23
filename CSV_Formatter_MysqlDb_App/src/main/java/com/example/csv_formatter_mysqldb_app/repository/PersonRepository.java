package com.example.csv_formatter_mysqldb_app.repository;


import com.example.csv_formatter_mysqldb_app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
