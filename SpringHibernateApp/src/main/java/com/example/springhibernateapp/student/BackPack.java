package com.example.springhibernateapp.student;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "backpacks")
public class BackPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "backPack") // zapis w pierwszej kolejnosci w klasie ktora nie ma mappedBy
    private List<NotePad> notePad;

    public BackPack(String name) {
        this.name = name;
    }
    public BackPack() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NotePad> getNotePad() {
        return notePad;
    }

    public void setNotePad(List<NotePad> notePad) {
        this.notePad = notePad;
    }

    @Override
    public String toString() {
        return "BackPack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
