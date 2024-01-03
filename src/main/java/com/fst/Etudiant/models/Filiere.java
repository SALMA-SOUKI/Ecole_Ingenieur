package com.fst.Etudiant.models;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filiereId;

    private String nomFiliere;
    private String description;
    private BigDecimal montantFraisInscription;
    private BigDecimal montantFraisScolarite;

    // Getters et setters
}
