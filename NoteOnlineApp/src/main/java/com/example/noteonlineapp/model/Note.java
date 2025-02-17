package com.example.noteonlineapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "notes")
@Data
public class Note {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private  String title;
        @Column(columnDefinition = "TEXT")
        private String content;
        @Column(nullable = false)
        private LocalDateTime createdAt = LocalDateTime.now();

}
