package com.sapient.test.response;

import java.io.Serializable;

public class CricketResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unique_id;
	private String team2;
	private String team1;
	private String winingTeamScore;
	private String roundRotation;
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getWiningTeamScore() {
		return winingTeamScore;
	}
	public void setWiningTeamScore(String winingTeamScore) {
		this.winingTeamScore = winingTeamScore;
	}
	public String getRoundRotation() {
		return roundRotation;
	}
	public void setRoundRotation(String roundRotation) {
		this.roundRotation = roundRotation;
	}
	public CricketResponse(String unique_id, String team2, String team1, String winingTeamScore, String roundRotation) {
		super();
		this.unique_id = unique_id;
		this.team2 = team2;
		this.team1 = team1;
		this.winingTeamScore = winingTeamScore;
		this.roundRotation = roundRotation;
	}
	public CricketResponse() {
		super();
	}
	
	
}
