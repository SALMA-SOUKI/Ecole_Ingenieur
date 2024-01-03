package com.fst.Etudiant.repositories;

import com.fst.Etudiant.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFiliere_FiliereId(Long filiereId);

    List<Student> findByClasse_ClasseId(Long classeId);
}
