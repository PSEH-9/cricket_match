package com.sapient.test.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchScoreRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("apikey")
	private String apikey;
	
	@JsonProperty("matchId")
	private String matchId;

	public MatchScoreRequest(String apikey, String matchId) {
		this.apikey = apikey;
		this.matchId = matchId;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	
}
