package com.example.noteonlineapp.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class NoteService {

    private final NoteRepository noteRepository;

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note findById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Optional<Note> update(Note noteToUpdate) {

        return findAll().stream()
                .filter(note -> Objects.equals(note.getId(), noteToUpdate.getId()))
                .findFirst()
                .map(note -> {
                    note.setTitle(noteToUpdate.getTitle());
                    note.setContent(noteToUpdate.getContent());
                    note.setCreatedAt(noteToUpdate.getCreatedAt());
                    return noteRepository.save(note);

                });
    }
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}
