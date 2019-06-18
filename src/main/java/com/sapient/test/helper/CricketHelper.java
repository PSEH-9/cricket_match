package com.sapient.test.helper;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.test.exceptions.InternalServerException;
import com.sapient.test.exceptions.InvalidMatchIdException;
import com.sapient.test.request.MatchDetailRequest;
import com.sapient.test.request.MatchScoreRequest;
import com.sapient.test.response.MatchData;
import com.sapient.test.response.MatchDataResponse;
import com.sapient.test.response.MatchScoreResponse;
import com.sapient.test.utils.AppConstant;
import com.sapient.test.utils.RestTemplateUtil;

@Component
public class CricketHelper {

	private static final Logger logger = LoggerFactory.getLogger(CricketHelper.class);
	private @Autowired RestTemplateUtil restTemplateUtil;

	private @Value("${cricapi.match_list.api}") String matchListAPI;
	private @Value("${cricapi.api.key}") String apiKey;
	private @Value("${cricapi.match_score.api}") String matchScoreAPI;
	private @Autowired ObjectMapper objectMapper;

	public MatchData getMatchData(int uniqueId) throws InvalidMatchIdException,InternalServerException, IOException {
		logger.info("getting match data for match id "+uniqueId);
		MatchDetailRequest matchDetailRequest = new MatchDetailRequest(apiKey);

		try {
			String endpoint = matchListAPI + uniqueId;

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(matchDetailRequest), headers);
			logger.info("invoking endpoint "+endpoint+" with headers "+entity);
			
			MatchDataResponse matchDataResponse = restTemplateUtil.invoke(endpoint, HttpMethod.POST, entity,
					MatchDataResponse.class);
			logger.info("matchDataResponse "+matchDataResponse);
			if (matchDataResponse != null && !CollectionUtils.isEmpty(matchDataResponse.getMatches())) {
				Optional<MatchData> matchDataOptional = matchDataResponse.getMatches().stream()
						.filter(e -> uniqueId == e.getUniqueId()).findFirst();
				if (matchDataOptional.isPresent()) {
					return matchDataOptional.get();
				} else {
					throw new InvalidMatchIdException(AppConstant.API_RESPONSE.INVALID_MATCH_ID_CODE,
							AppConstant.API_RESPONSE.INVALID_MATCH_ID_MESSAGE);
				}
			} else {
				throw new InternalServerException(AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_CODE,
						AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_MESSAGE);
			}
		} catch (RestClientException rce) {
			logger.error("exception occurred " + rce);
			throw new InternalServerException(AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_CODE,
					AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}

	public MatchScoreResponse getMatchScore(String matchId) throws InternalServerException, IOException {
		logger.info("getMatchScore for match id "+matchId);
		MatchScoreRequest matchScoreRequest = new MatchScoreRequest(apiKey, matchId);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(matchScoreRequest), headers);
		try {
			MatchScoreResponse matchScoreResponse = restTemplateUtil.invoke(matchScoreAPI, HttpMethod.POST, entity,
					MatchScoreResponse.class);
			logger.info("matchScoreResponse "+matchScoreResponse);
			return matchScoreResponse;
		} catch (RestClientException rce) {
			logger.error("exception occurred " + rce);
			throw new InternalServerException(AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_CODE,
					AppConstant.API_RESPONSE.INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}

}
