package com.fsts;

import com.fsts.Model.Note;
import com.fsts.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class NoteServiceApplication implements CommandLineRunner {

	@Autowired
	NoteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(NoteServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Note> NoteList = new ArrayList<>();
		NoteList.add(new Note(null,1L,101L,20, LocalDate.now(),null));
		NoteList.add(new Note(null,2L,102L,18, LocalDate.now(),null));
		repository.saveAll(NoteList);
	}
}