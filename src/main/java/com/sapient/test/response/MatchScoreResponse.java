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
@JsonPropertyOrder({ "stat", "score", "description", "matchStarted", "team-1", "team-2", "v", "ttl", "provider",
		"creditsLeft" })
public class MatchScoreResponse {

	@JsonProperty("stat")
	private String stat;
	@JsonProperty("score")
	private String score;
	@JsonProperty("description")
	private String description;
	@JsonProperty("matchStarted")
	private boolean matchStarted;
	@JsonProperty("team-1")
	private String team1;
	@JsonProperty("team-2")
	private String team2;
	@JsonProperty("v")
	private String v;
	@JsonProperty("ttl")
	private int ttl;
	@JsonProperty("provider")
	private Provider provider;
	@JsonProperty("creditsLeft")
	private int creditsLeft;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("stat")
	public String getStat() {
		return stat;
	}

	@JsonProperty("stat")
	public void setStat(String stat) {
		this.stat = stat;
	}

	@JsonProperty("score")
	public String getScore() {
		return score;
	}

	@JsonProperty("score")
	public void setScore(String score) {
		this.score = score;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("matchStarted")
	public boolean isMatchStarted() {
		return matchStarted;
	}

	@JsonProperty("matchStarted")
	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

	@JsonProperty("team-1")
	public String getTeam1() {
		return team1;
	}

	@JsonProperty("team-1")
	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	@JsonProperty("team-2")
	public String getTeam2() {
		return team2;
	}

	@JsonProperty("team-2")
	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	@JsonProperty("v")
	public String getV() {
		return v;
	}

	@JsonProperty("v")
	public void setV(String v) {
		this.v = v;
	}

	@JsonProperty("ttl")
	public int getTtl() {
		return ttl;
	}

	@JsonProperty("ttl")
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	@JsonProperty("provider")
	public Provider getProvider() {
		return provider;
	}

	@JsonProperty("provider")
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@JsonProperty("creditsLeft")
	public int getCreditsLeft() {
		return creditsLeft;
	}

	@JsonProperty("creditsLeft")
	public void setCreditsLeft(int creditsLeft) {
		this.creditsLeft = creditsLeft;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "source", "url", "pubDate" })
class Provider {

	@JsonProperty("source")
	private String source;
	@JsonProperty("url")
	private String url;
	@JsonProperty("pubDate")
	private String pubDate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("pubDate")
	public String getPubDate() {
		return pubDate;
	}

	@JsonProperty("pubDate")
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
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
