package com.sapient.test.request;

import java.io.Serializable;

public class MatchScoreRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String apiKey;
	private String matchId;

	public MatchScoreRequest(String apiKey, String matchId) {
		this.apiKey = apiKey;
		this.matchId = matchId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	
}
