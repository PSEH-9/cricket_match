package com.sapient.test.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.test.exceptions.InternalServerException;
import com.sapient.test.exceptions.InvalidMatchIdException;
import com.sapient.test.helper.CricketHelper;
import com.sapient.test.response.CricketResponse;
import com.sapient.test.response.MatchData;
import com.sapient.test.response.MatchScoreResponse;
import com.sapient.test.service.CricketService;
import com.sapient.test.utils.AppConstant;

@Service
public class CricketServiceImpl implements CricketService {

	private static final Logger logger = LoggerFactory.getLogger(CricketServiceImpl.class);
	private @Autowired CricketHelper cricketHelper;

	@Override
	public CricketResponse getCricketData(String matchId) throws InvalidMatchIdException, InternalServerException {
		// First check whether entered matchId is valid or not
		try {
			logger.info("inside getCricketData with matchid " + matchId);
			MatchData matchData = cricketHelper.getMatchData(Integer.valueOf(matchId));
			CricketResponse cricketResponse = new CricketResponse();
			logger.info("cricketResponse " + cricketResponse);
			cricketResponse.setTeam1(matchData.getTeam1());
			cricketResponse.setTeam2(matchData.getTeam2());
			cricketResponse.setUnique_id(matchId);
			if (matchData.isMatchStarted()) {
				logger.info("match started");
				MatchScoreResponse matchScoreResonse = cricketHelper.getMatchScore(matchId);
				logger.info("matchScoreResonse " + matchScoreResonse);
				String stat = matchScoreResonse.getStat();
				logger.info("stat " + stat);
				String winnerTeam = "";
				if (stat.contains(cricketResponse.getTeam1())) {
					winnerTeam = cricketResponse.getTeam1();
				} else if (stat.contains(cricketResponse.getTeam2())) {
					winnerTeam = cricketResponse.getTeam2();
				} else {
					winnerTeam = stat;
				}
				cricketResponse.setWiningTeamScore(winnerTeam);
			} else {
				cricketResponse.setWiningTeamScore(AppConstant.MATCH_NOT_STARTED);
			}
			return cricketResponse;
		} catch (IOException e) {
			logger.error("exception occurred " + e);
			throw new InternalServerException(AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_CODE,
					AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_MESSAGE);
		}

	}

}
