package com.customers.customers.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customers.customers.Entity.Affectation;
import com.customers.customers.Service.AffectationService;

import java.util.List;

@RestController
@RequestMapping("/api/affectations")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @GetMapping
    public List<Affectation> getAllAffectations() {
        return affectationService.getAllAffectations();
    }

    @GetMapping("/{id}")
    public Affectation getAffectationById(@PathVariable Long id) throws NotFoundException {
        return affectationService.getAffectationById(id);
    }

    @PostMapping
    public Affectation addAffectation(@RequestBody Affectation affectation) throws NotFoundException {
        return affectationService.addAffectation(affectation);
    }

    @PutMapping("/{id}")
    public Affectation updateAffectation(@PathVariable Long id, @RequestBody Affectation affectation) throws NotFoundException {
        return affectationService.updateAffectation(id, affectation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffectation(@PathVariable Long id) throws NotFoundException {
        affectationService.deleteAffectation(id);
        return ResponseEntity.ok().build();
    }
}

