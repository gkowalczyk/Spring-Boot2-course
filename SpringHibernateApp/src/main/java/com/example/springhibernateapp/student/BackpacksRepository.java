package com.example.springhibernateapp.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BackpacksRepository extends JpaRepository<BackPack, Long> {
}
