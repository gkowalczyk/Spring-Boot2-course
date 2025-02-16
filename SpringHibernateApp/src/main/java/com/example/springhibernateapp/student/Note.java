package com.example.springhibernateapp.student;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    @ManyToOne
    private NotePad notePad;

    public Note() {
    }

    public NotePad getNotePad() {
        return notePad;
    }

    public void setNotePad(NotePad notePad) {
        this.notePad = notePad;
    }

    public Note(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
