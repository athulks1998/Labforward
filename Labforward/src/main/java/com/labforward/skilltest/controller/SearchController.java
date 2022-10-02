package com.labforward.skilltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.skilltest.constant.ApplicationConstants;
import com.labforward.skilltest.dto.SearchRequestDTO;
import com.labforward.skilltest.dto.SearchResponseDTO;
import com.labforward.skilltest.service.search.SearchService;

/**
 * @author Athul KS INFO : Controller Class for the search related
 *         functionalities
 */
@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	/**
	 * @return returns the Response data based on the result INFO : API Controller
	 *         for word search functionality
	 */
	@PostMapping("/labnotebook/entry/search")
	@ResponseBody
	public ResponseEntity<SearchResponseDTO> findSimilarWords(@RequestBody final SearchRequestDTO searchRequest) {
		SearchResponseDTO result = searchService.findSimilarWordsService(searchRequest);

		// Based on response code set the Http status for the response 
		if (result.getStatusCode() == ApplicationConstants.RESPONSE_CODE_200) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
		} else if (result.getStatusCode() == ApplicationConstants.RESPONSE_CODE_400) {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(result);
		} else {
			return ResponseEntity.internalServerError().contentType(MediaType.APPLICATION_JSON).body(result);
		}

	}
}