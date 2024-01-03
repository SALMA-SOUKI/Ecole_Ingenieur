package com.fst.Etudiant.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "etudiant")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
//    private String CNE;
//    private String CIN;
//    private String immatriculation;
//    private String niveauEtude;
//    private String nomParents;
//    private String prenomParents;
//    private String telParents;
//    private String email;


    // Getters et setters
}
