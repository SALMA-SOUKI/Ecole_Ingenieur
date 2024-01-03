package com.fst.Etudiant.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class StudentDTO {
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
    private Long filiereId; // l'ID de la filière à laquelle l'étudiant s'inscrit
    private Long classeId;  // l'ID de la classe à laquelle l'étudiant est affecté

    // Getters et setters
}
