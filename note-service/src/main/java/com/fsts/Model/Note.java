package com.fsts.Model;

import com.fsts.Feign.EtudiantDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="notes")
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="etudiant_id")
    private Long EtudiantId;

    @Column(name="matiere_id")
    private Long matiereId;

    @Column(name="valeur_note")
    private double valeurNote;

    @Column(name="date_saisie")
    private LocalDate dateSaisie;

    @Transient
    private EtudiantDTO etudiant;
}
