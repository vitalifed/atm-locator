package com.backbase.assignment.solution;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backbase.assignment.solution.service.AtmRestClient;
import com.backbase.assignment.solution.service.ProcessorFactory;
import com.backbase.assignment.solution.util.Processor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Configuration
@ComponentScan("com.backbase.assignment.solution.service")
@PropertySource("classpath:application.properties")
public class AtmRestClientTest {

	@Autowired
	private AtmRestClient client;

	@Autowired
	private ProcessorFactory processorFactory;

	private static final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testInvalidJson() throws JsonProcessingException, IOException {
		String json = processorFactory.processor(Processor.RAW).filterByCity(client.getAllLocations(), "Rijswijk");

		assertEquals(0, mapper.readTree(json).findValues("city").stream()
				.filter(j -> !j.asText().equalsIgnoreCase("Rijswijk")).collect(Collectors.toList()).size());

	}

}
