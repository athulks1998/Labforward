package com.labforward.skilltest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.labforward.skilltest.model.LabNotebook;

/**
 * @author Athul K S INFO : Repository class for Lab Notebook
 */
@Repository
public interface LabNotebookRepository extends MongoRepository<LabNotebook, String> {

	/**
	 * @param id ID of the entry passed to find the record
	 * @return Returns the lab notebook entry with the corresponding id
	 */
	@Query("{id:'?0'}")
	LabNotebook findEntryById(String id);

}
