package com.fst.Etudiant.models;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "etudiant")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String CNE;
    private String CIN;
    private String immatriculation;
    private String niveauEtude;
    private String nomParents;
    private String prenomParents;
    private String telParents;
    private String email;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe  classe;

    private Date dateInscription;


    // Getters et setters
}
