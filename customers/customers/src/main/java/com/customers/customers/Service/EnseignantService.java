package com.customers.customers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.customers.customers.Entity.Enseignant;
import com.customers.customers.Repository.EnseignantRepository;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) throws NotFoundException {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public Enseignant updateEnseignant(Long id, Enseignant enseignant) throws NotFoundException {
        Enseignant existingEnseignant = getEnseignantById(id);
        existingEnseignant.setNom(enseignant.getNom());
        existingEnseignant.setPrenom(enseignant.getPrenom());
        return enseignantRepository.save(existingEnseignant);
    }

    public void deleteEnseignant(Long id) throws NotFoundException {
        Enseignant existingEnseignant = getEnseignantById(id);
        enseignantRepository.delete(existingEnseignant);
    }
}

