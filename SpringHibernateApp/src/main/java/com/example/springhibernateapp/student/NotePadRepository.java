package com.example.springhibernateapp.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotePadRepository extends JpaRepository<NotePad, Long> {
}
