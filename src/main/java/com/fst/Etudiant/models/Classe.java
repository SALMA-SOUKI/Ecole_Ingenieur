package com.fst.Etudiant.models;


import jakarta.persistence.*;

@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classeId;

    private String nomClasse;
    private String description;

    // Getters et setters
}