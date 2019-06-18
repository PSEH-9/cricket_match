package com.sapient.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {

	private @Autowired RestTemplate restTemplate;

	public <T> T invoke(String endpoint, HttpMethod httpMethod, HttpEntity<?> httpEntity,
			Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(endpoint, httpMethod, httpEntity, responseType).getBody();
	}
}
