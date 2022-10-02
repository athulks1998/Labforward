package com.labforward.skilltest.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Athul K S INFO : The Response DTO for search result in a lab entry
 */
@Getter
@Setter
public class SearchResponseDTO {

	/**
	 * INFO : Field to Store the number of exact matches
	 */
	@JsonProperty("word_frequency")
	private int wordFrequency;

	/**
	 * INFO : Field to store the similar words that are found in the search
	 */
	@JsonProperty("similar_words")
	private Set<String> similarWords;

	/**
	 * INFO : Field to store the status of the API
	 */
	private String status;

	/**
	 * INFO : Field to store the status code of the API
	 */
	@JsonProperty("status_code")
	private int statusCode;

	/**
	 * INFO : Field to store the success and failure messages of the API
	 */
	private String message;
}
