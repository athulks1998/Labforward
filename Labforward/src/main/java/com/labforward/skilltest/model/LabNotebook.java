package com.labforward.skilltest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Athul KS
 * 
 *         INFO: Model class for storing lab entries in mongo db
 * 
 */
@Document("labnotebook")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LabNotebook {

	/**
	 * INFO : Field to Store the Unique ID
	 */
	@Id
	private String id;

	/**
	 * INFO: Field to Store the name of the entry
	 */
	private String name;

	/**
	 * INFO: Field to store the different lab entries
	 */
	private String labEntry;

}
