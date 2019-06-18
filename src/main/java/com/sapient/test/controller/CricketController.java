package com.sapient.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.test.exceptions.InternalServerException;
import com.sapient.test.exceptions.InvalidMatchIdException;
import com.sapient.test.response.CricketResponse;
import com.sapient.test.response.Meta;
import com.sapient.test.response.ResponseEntity;
import com.sapient.test.service.CricketService;
import com.sapient.test.utils.AppConstant;

@RestController
public class CricketController {
	
	private static final Logger logger = LoggerFactory.getLogger(CricketController.class);

	private @Autowired CricketService cricketService;

	@GetMapping(path = "v1/sapient/cricket_score/{matchId}", produces = "application/json")
	public ResponseEntity<?> getMatchDetails(@PathVariable(name = "matchId") String matchId) throws InvalidMatchIdException, InternalServerException {
		logger.info("getMatchDetails with matchid "+matchId);
		CricketResponse cricketResponse = cricketService.getCricketData(matchId);
		logger.info("cricketResponse  "+cricketResponse);
		Meta meta = new Meta(AppConstant.API_RESPONSE.SUCCESS_CODE, AppConstant.API_RESPONSE.SUCCESS_MESSAGE);
		return new ResponseEntity(meta, cricketResponse);
	}
}
