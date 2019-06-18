package com.sapient.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CricketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketServiceApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestTemplate()	{
		return new RestTemplate();
	}
}
