package com.customers.customers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customers.customers.Entity.Enseignant;
import com.customers.customers.Service.EnseignantService;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable Long id) throws NotFoundException {
        return enseignantService.getEnseignantById(id);
    }

    @PostMapping
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.addEnseignant(enseignant);
    }

    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable Long id, @RequestBody Enseignant enseignant) throws NotFoundException {
        return enseignantService.updateEnseignant(id, enseignant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnseignant(@PathVariable Long id) throws NotFoundException {
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.ok().build();
    }
}

