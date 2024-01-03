package com.fsts.Controller;

import com.fsts.Feign.EtudiantDTO;
import com.fsts.Feign.EtudiantFeignClient;
import com.fsts.Model.Note;
import com.fsts.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    private final NoteService noteServ;

    @Autowired
    private EtudiantFeignClient etudiantFeignClient;

    @Autowired
    public NoteController(NoteService noteServ) {
        this.noteServ = noteServ;
    }

    @GetMapping("all")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteServ.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Note> getNotById(@PathVariable Long id){
        Note note = noteServ.getNoteById(id);
        EtudiantDTO etudiant = etudiantFeignClient.getEtudiantById(note.getEtudiantId());
        note.setEtudiant(etudiant);
        return new ResponseEntity<>(note,HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        Note newnote = noteServ.AddNote(note);
        return new ResponseEntity<>(newnote,HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        Note updatedNote = noteServ.updateNote(note);
        return new ResponseEntity<>(updatedNote,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id ){
        noteServ.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
