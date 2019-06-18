package com.sapient.test.service;

import com.sapient.test.exceptions.InternalServerException;
import com.sapient.test.exceptions.InvalidMatchIdException;
import com.sapient.test.response.CricketResponse;

public interface CricketService {
	public CricketResponse getCricketData(String matchId) throws InvalidMatchIdException, InternalServerException;
}
