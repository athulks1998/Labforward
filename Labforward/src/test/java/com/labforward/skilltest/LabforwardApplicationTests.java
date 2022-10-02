package com.labforward.skilltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.labforward.skilltest.constant.ApplicationConstants;
import com.labforward.skilltest.dto.SearchRequestDTO;
import com.labforward.skilltest.dto.SearchResponseDTO;
import com.labforward.skilltest.service.search.SearchService;

/**
 * @author Athul K S
 * INFO : Test class for This Application 
 */
@SpringBootTest
class LabforwardApplicationTests {
	
	@Autowired
	SearchService searchService;

	 /**
	 * INFO : Test case for the success case of search functionality 
	 */
	@Test
	  void testSearchWordSuccessCase() {
		   // Setting all properties as expected to get a success response 
		  SearchRequestDTO request = new SearchRequestDTO();
		  request.setId("id1");
		  request.setSearchText("Word");
		  SearchResponseDTO response =  searchService.findSimilarWordsService(request);
		  assertEquals(ApplicationConstants.SEARCH_MESSAGE_SUCCESS, response.getMessage());
		  assertEquals(ApplicationConstants.RESPONSE_CODE_200, response.getStatusCode());
		  assertEquals(1, response.getWordFrequency());
		  assertEquals(3, response.getSimilarWords().size());
	  }
	  
	  
	/**
	 * INFO : Test case for failure case Bad Request 400  
	 */
	@Test
	  void testSearchWordFailureCase() {	   
		  SearchRequestDTO request = new SearchRequestDTO();
		  request.setId("id1");
		  // Setting the request data as null 
		  request.setSearchText(null);
		  SearchResponseDTO response =  searchService.findSimilarWordsService(request);
		  assertEquals(ApplicationConstants.SEARCH_MESSAGE_FAILURE, response.getMessage());
		  assertEquals(ApplicationConstants.RESPONSE_CODE_400, response.getStatusCode());
	  }
	
	
	/**
	 * INFO : Test case for failure case Internal Server Error 500   
	 */
	@Test
	  void testSearchWordInternalServerError() {	   
		  SearchRequestDTO request = new SearchRequestDTO();
		  //Setting an Id which is not present in the DB 
		  request.setId("id2");
		  request.setSearchText("word");
		  SearchResponseDTO response =  searchService.findSimilarWordsService(request);
		  assertEquals(ApplicationConstants.SEARCH_MESSAGE_FAILURE, response.getMessage());
		  assertEquals(ApplicationConstants.RESPONSE_CODE_500, response.getStatusCode());
	  }


}
