package com.example.noteonlineapp.controller;

import com.example.noteonlineapp.model.Note;
import com.example.noteonlineapp.service.NoteService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@CrossOrigin("*")
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping()
    public ResponseEntity<List<Note>> getNotes() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return noteService.update(note)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noteService.save(note));

    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        noteService.deleteById(id);
    }

}
