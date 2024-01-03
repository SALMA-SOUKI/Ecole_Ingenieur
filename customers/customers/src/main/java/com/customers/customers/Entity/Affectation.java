package com.customers.customers.Entity;


import com.customers.customers.Dto.Classe;
import com.customers.customers.Dto.Module;

import jakarta.persistence.*
;

@Entity
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long affectationId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    // Other fields and methods as needed

    // Getters and setters
    public Long getAffectationId() {
        return affectationId;
    }

    public void setAffectationId(Long affectationId) {
        this.affectationId = affectationId;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}

