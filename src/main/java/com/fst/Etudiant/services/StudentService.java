package com.fst.Etudiant.services;

import com.fst.Etudiant.models.Student;
import com.fst.Etudiant.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentsByFiliere(Long filiereId) {
        return studentRepository.findByFiliere_FiliereId(filiereId);
    }

    public List<Student> getStudentsByClasse(Long classeId) {
        return studentRepository.findByClasse_ClasseId(classeId);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Étudiant non trouvé avec l'ID : " + id));
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

        // Update fields of the existing student with the updated student data
        existingStudent.setNom(updatedStudent.getNom());
        existingStudent.setPrenom(updatedStudent.getPrenom());
        existingStudent.setCIN(updatedStudent.getCIN());
        existingStudent.setCNE(updatedStudent.getCNE());
        existingStudent.setClasse(updatedStudent.getClasse());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDateNaissance(updatedStudent.getDateNaissance());
        existingStudent.setImmatriculation(updatedStudent.getImmatriculation());
        existingStudent.setFiliere(updatedStudent.getFiliere());

        existingStudent.setNiveauEtude(updatedStudent.getNiveauEtude());
        existingStudent.setNomParents(updatedStudent.getNomParents());

        existingStudent.setDateInscription(updatedStudent.getDateInscription());
        existingStudent.setTelParents(updatedStudent.getTelParents());





        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
