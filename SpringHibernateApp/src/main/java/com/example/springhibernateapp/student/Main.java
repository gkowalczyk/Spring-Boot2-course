package com.example.springhibernateapp.student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Main {

    public Main(StudentRepository studentRepository, BackpacksRepository backpacksRepository,
                NotePadRepository notePadRepository, ProfessorRepository professorRepository,
                RoomRepository roomRepository, CleanerRepository cleanerRepository,
                NoteRepository noteRepository) {


        BackPack backPack = new BackPack("Adidas");
        BackPack backPack2 = new BackPack("Nike");

        backpacksRepository.save(backPack);
        backpacksRepository.save(backPack2);

        NotePad notePad = new NotePad("NotePad1");
        Note note = new Note(1);
        Note note2 = new Note(2);
        note.setNotePad(notePad);
        note2.setNotePad(notePad);
        notePad.setBackPack(backPack);
        notePad.setBackPack(backPack2);

        notePadRepository.save(notePad);
        noteRepository.save(note);
        noteRepository.save(note2);

        Student student = new Student("John", "Doe", "25");
        student.setBackPack(backPack);
        Student student2 = new Student("Jane", "Doe", "25");
        student2.setBackPack(backPack2);
        //studentRepository.save(student);
        // studentRepository.save(student2);
        List<Student> students = Stream.of(student, student2).toList();

        Professor professor = new Professor("John", "Doe", "PhD");
        Professor professor2 = new Professor("Jane", "Doe", "PhD");
        // professorRepository.save(professor);
        // professorRepository.save(professor2);
        List<Professor> professors = Stream.of(professor, professor2).toList();

        Room room = new Room(1);
        Room room1 = new Room(2);
        List<Room> rooms = Stream.of(room, room1).toList();

        professor.setStudents(students);
        professor2.setStudents(students);
        professor.setRoom(room);
        professor2.setRoom(room1);

        student.setProfessors(professors);
        student2.setProfessors(professors);

        studentRepository.save(student);
        studentRepository.save(student2);

        roomRepository.save(room);
        roomRepository.save(room1);

        professorRepository.save(professor);
        professorRepository.save(professor2);

        Cleaner cleaner = new Cleaner("Jan", "Niezbędny");
        Cleaner cleaner2 = new Cleaner("Janusz", "Sprzątacz");
        List<Cleaner> cleaners = Stream.of(cleaner, cleaner2).toList();
        cleaner.setRooms(rooms);
        cleaner2.setRooms(rooms);

        cleanerRepository.save(cleaner);
        cleanerRepository.save(cleaner2);

        room.setCleaners(cleaners);
        room1.setCleaners(cleaners);
        roomRepository.save(room);
        roomRepository.save(room1);
    }
}
