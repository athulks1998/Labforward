package com.labforward.skilltest.service.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labforward.skilltest.constant.ApplicationConstants;
import com.labforward.skilltest.dto.SearchRequestDTO;
import com.labforward.skilltest.dto.SearchResponseDTO;
import com.labforward.skilltest.exception.CustomException;
import com.labforward.skilltest.model.LabNotebook;
import com.labforward.skilltest.repository.LabNotebookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Athul K S INFO :
 */
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

	/**
	 * INFO: Repository Object Injected
	 */
	@Autowired
	LabNotebookRepository noteBookRespository;

	/**
	 * INFO : Implementation method for word search based on levenshtein distance
	 */
	@Override
	public SearchResponseDTO findSimilarWordsService(SearchRequestDTO searchRequest) {
		log.info("Entry : Fetch word frequency and similar words");
		SearchResponseDTO response = new SearchResponseDTO();
		try {
			if (Objects.isNull(searchRequest.getId()) || Objects.isNull(searchRequest.getSearchText())
					|| searchRequest.getId().isEmpty()) {
				throw new CustomException("Bad Request");
			}
			LabNotebook labEntry = noteBookRespository.findEntryById(searchRequest.getId());
			String entryData = labEntry.getLabEntry();
			//Remove unwanted characters 
			entryData = entryData.replaceAll("[!?,]", "");
			// Split the text in words 
			List<String> words = Arrays.asList(entryData.split("\\s+"));

			LevenshteinDistance levenshtein = LevenshteinDistance.getDefaultInstance();
			Set<String> similarWords = new HashSet<>();
			words.stream().forEach(word -> {
				// calculating the levenshtein distance
				int distance = levenshtein.apply(word, searchRequest.getSearchText());

				if (distance == 0) {
					// Enters this block if the words exactly matches
					response.setWordFrequency(response.getWordFrequency() + 1);
				} else if (distance == 1) {
					// Enters for similar words
					similarWords.add(word);
				}
			});
			response.setSimilarWords(similarWords);
			response.setMessage(ApplicationConstants.SEARCH_MESSAGE_SUCCESS);
			response.setStatusCode(ApplicationConstants.RESPONSE_CODE_200);
			response.setStatus(ApplicationConstants.STATUS_SUCCESS);
		} catch (CustomException customException) {

			log.error("Error : " + customException.getMessage());
			response.setMessage(ApplicationConstants.SEARCH_MESSAGE_FAILURE);
			response.setStatus(ApplicationConstants.STATUS_FAILURE);
			response.setStatusCode(ApplicationConstants.RESPONSE_CODE_400);
		} catch (Exception exception) {
			log.error("Error : " + exception.getMessage());
			response.setMessage(ApplicationConstants.SEARCH_MESSAGE_FAILURE);
			response.setStatusCode(ApplicationConstants.RESPONSE_CODE_500);
			response.setStatus(ApplicationConstants.STATUS_FAILURE);
		} finally {

			log.info("Exit : Fetch word frequency and similar words");
		}

		return response;
	}


}
