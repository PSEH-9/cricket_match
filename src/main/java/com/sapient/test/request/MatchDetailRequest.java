package com.sapient.test.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDetailRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("apikey")
	private String apikey;

	public MatchDetailRequest(String apikey) {
		this.apikey = apikey;
	}

	public String getApiKey() {
		return apikey;
	}

	public void setApiKey(String apikey) {
		this.apikey = apikey;
	}
	
	
}
