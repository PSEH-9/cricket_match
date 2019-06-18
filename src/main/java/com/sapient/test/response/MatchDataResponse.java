package com.sapient.test.response;

import java.io.Serializable;
import java.util.List;

public class MatchDataResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private boolean cache;
	private List<MatchData> matches;

//	public boolean isCache() {
//		return cache;
//	}
//
//	public void setCache(boolean cache) {
//		this.cache = cache;
//	}

	public List<MatchData> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchData> matches) {
		this.matches = matches;
	}

}
