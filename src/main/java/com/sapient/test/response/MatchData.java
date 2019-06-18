package com.sapient.test.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "unique_id", "date", "team-2", "team-1", "matchStarted", "squad" })
public class MatchData {

	@JsonProperty("unique_id")
	private int uniqueId;
	@JsonProperty("date")
	private String date;
	@JsonProperty("team-2")
	private String team2;
	@JsonProperty("team-1")
	private String team1;
	@JsonProperty("matchStarted")
	private boolean matchStarted;
	@JsonProperty("squad")
	private boolean squad;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("unique_id")
	public int getUniqueId() {
		return uniqueId;
	}

	@JsonProperty("unique_id")
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("team-2")
	public String getTeam2() {
		return team2;
	}

	@JsonProperty("team-2")
	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	@JsonProperty("team-1")
	public String getTeam1() {
		return team1;
	}

	@JsonProperty("team-1")
	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	@JsonProperty("matchStarted")
	public boolean isMatchStarted() {
		return matchStarted;
	}

	@JsonProperty("matchStarted")
	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

	@JsonProperty("squad")
	public boolean isSquad() {
		return squad;
	}

	@JsonProperty("squad")
	public void setSquad(boolean squad) {
		this.squad = squad;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
