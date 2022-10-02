package com.labforward.skilltest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Athul K S
 *
 *         INFO : Request DTO for levenshtein search in a lab entry
 */
@Getter
@Setter
public class SearchRequestDTO {

	/**
	 * INFO: Field to store id of the entry in request
	 */
	@JsonProperty("id")
	private String id;

	/**
	 * INFO: Field to store the word that needs to be searched
	 */
	@JsonProperty("search_text")
	private String searchText;
}
