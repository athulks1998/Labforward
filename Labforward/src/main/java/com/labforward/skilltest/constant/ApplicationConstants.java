package com.labforward.skilltest.constant;

/**
 * @author Athul KS INFO : Constant class to store common values
 */
public final class ApplicationConstants {

	private ApplicationConstants() {
	}

	///////////////////////////// Response Codes ////////////////////////

	public static final int RESPONSE_CODE_200 = 200;

	public static final int RESPONSE_CODE_500 = 500;

	public static final int RESPONSE_CODE_400 = 400;

	///////////////////////////// Response Messages//////////////////////

	public static final String SEARCH_MESSAGE_SUCCESS = "Analysed the lab entry for matching words!";

	public static final String SEARCH_MESSAGE_FAILURE = "Failed to find similar words and frequency!";

	//////////////////////////// Response Status///////////////////////////

	public static final String STATUS_SUCCESS = "Success!";

	public static final String STATUS_FAILURE = "Failure!";

}
