package com.fst.Etudiant;

import com.fst.Etudiant.models.Student;
import com.fst.Etudiant.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EtudiantApplication implements CommandLineRunner {

	@Autowired
	StudentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(null,"yasser","bouhouaili", LocalDate.of(2000, Month.MAY,5)));
		studentList.add(new Student(null,"hamza","nadi", LocalDate.of(2000, Month.JANUARY,2)));
		studentList.add(new Student(null,"haitam","pc", LocalDate.of(2000, Month.JANUARY,3)));
		repo.saveAll(studentList);
	}
}
