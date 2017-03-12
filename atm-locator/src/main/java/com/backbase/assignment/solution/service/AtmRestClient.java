package com.backbase.assignment.solution.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AtmRestClient {

	@Value("${ing.url.locator.atm}")
	private String ingAtmlURL;

	private RestTemplate template = new RestTemplate();

	public String getAllLocations() {
		return template.getForObject(ingAtmlURL, String.class);
	}

}