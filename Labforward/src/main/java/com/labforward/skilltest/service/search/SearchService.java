package com.labforward.skilltest.service.search;

import com.labforward.skilltest.dto.SearchRequestDTO;
import com.labforward.skilltest.dto.SearchResponseDTO;

/**
 * @author Athul KS INFO : Service Interface for Search related Services
 */
public interface SearchService {

	/**
	 * @param searchRequest The request body for finding similar words
	 * @return The response body with word frequency and similar words
	 */
	public SearchResponseDTO findSimilarWordsService(SearchRequestDTO searchRequest);

}
