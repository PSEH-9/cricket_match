package com.sapient.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.test.utils.MyPropertyNamingStrategy;

@SpringBootApplication
public class CricketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketServiceApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestTemplate()	{
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper getObjectMapper()	{
		ObjectMapper obMapper = new ObjectMapper();
//		obMapper.setPropertyNamingStrategy(new MyPropertyNamingStrategy());
		return obMapper;
	}
}
