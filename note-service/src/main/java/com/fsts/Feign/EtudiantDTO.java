package com.fsts.Feign;

import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EtudiantDTO {
    private Long id;
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


}
