package com.labforward.skilltest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.labforward.skilltest.model.LabNotebook;
import com.labforward.skilltest.repository.LabNotebookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Athul K S INFO : Application class
 *
 */
@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class LabforwardApplication implements CommandLineRunner {

	/**
	 * Injecting the repository for Labnotebook
	 */
	@Autowired
	LabNotebookRepository notebookRepo;

	public static void main(String[] args) {
		SpringApplication.run(LabforwardApplication.class, args);
	}

	/**
	 * Sets up Initial Data during startup
	 */
	@Override
	public void run(String... args) throws Exception {
		try {
			log.info("Entry : Create startup entries");
			List<LabNotebook> noteBook = new ArrayList<>();
			noteBook.add(new LabNotebook("id0", "Project1", "Word Word Word word"));
			noteBook.add(new LabNotebook("id1", "Project2", "Word Words Wor word"));
			notebookRepo.insert(noteBook);
		} catch (Exception e) {
			log.info("The Startup data already exists");
		} finally {
			log.info("Exit : Create startup entries");
		}

	}

}
