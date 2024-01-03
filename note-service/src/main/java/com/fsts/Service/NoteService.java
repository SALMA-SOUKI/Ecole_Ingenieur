package com.fsts.Service;

import com.fsts.Model.Note;
import com.fsts.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepo;

    @Autowired
    public NoteService(NoteRepository noteRepo){
        this.noteRepo = noteRepo;
    }

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepo.findNoteById(id).orElseThrow(()-> new NoteNotFoundException("Note by id "+id+" Not Found"));
    }

    public Note AddNote(Note note) {
        note.setDateSaisie(LocalDate.now());
        return noteRepo.save(note);
    }

    public Note updateNote(Note note) {
        return noteRepo.save(note);
    }

    public void deleteNote (Long id) {
        noteRepo.deleteById(id);
    }


}
