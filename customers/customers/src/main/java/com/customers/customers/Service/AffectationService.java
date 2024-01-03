package com.customers.customers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.customers.customers.Dto.Classe;
import com.customers.customers.Dto.Module;

import com.customers.customers.Entity.Affectation;
import com.customers.customers.Entity.Enseignant;
import com.customers.customers.Repository.AffectationRepository;
import com.customers.customers.Repository.ClasseRepository;
import com.customers.customers.Repository.EnseignantRepository;
import com.customers.customers.Repository.ModuleRepository;

import java.util.List;

@Service
public class AffectationService {

    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Affectation> getAllAffectations() {
        return affectationRepository.findAll();
    }

    public Affectation getAffectationById(Long id) throws NotFoundException {
        return affectationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public Affectation addAffectation(Affectation affectation) throws NotFoundException {
    	Enseignant enseignant = getEnseignantById(affectation.getEnseignant().getTeacherId());
        Classe classe = getClasseById(affectation.getClasse().getClasseId());
        Module module = getModuleById(affectation.getModule().getModuleId());
        affectation.setEnseignant(enseignant);
        affectation.setClasse(classe);
        affectation.setModule(module);
        return affectationRepository.save(affectation);
    }

    public Affectation updateAffectation(Long id, Affectation affectation) throws NotFoundException {
        Affectation existingAffectation = getAffectationById(id);
        Enseignant enseignant = getEnseignantById(affectation.getEnseignant().getTeacherId());
        Classe classe = getClasseById(affectation.getClasse().getClasseId());
        Module module = getModuleById(affectation.getModule().getModuleId());
        existingAffectation.setEnseignant(enseignant);
        existingAffectation.setClasse(classe);
        existingAffectation.setModule(module);
        return affectationRepository.save(existingAffectation);
    }

    public void deleteAffectation(Long id) throws NotFoundException {
        Affectation existingAffectation = getAffectationById(id);
        affectationRepository.delete(existingAffectation);
    }

    private Enseignant getEnseignantById(Long id) throws NotFoundException {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    private Classe getClasseById(Long id) throws NotFoundException {
        return classeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    private Module getModuleById(Long id) throws NotFoundException {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
}

