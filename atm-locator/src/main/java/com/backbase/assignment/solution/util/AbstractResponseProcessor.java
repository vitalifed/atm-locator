package com.backbase.assignment.solution.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractResponseProcessor implements ResponseProcessor {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<Map> readValue(String json) throws JsonParseException, JsonMappingException, IOException{
		//https://www.ing.nl/api/locator/atms/
		//The json response is not well formed, the number of invalid characters leads the JSON contents 
		//)]}',
		return mapper.readValue(JsonRawResponseProcessor.class.getResourceAsStream("/allATM.json"), List.class);
	}
	
	protected <T> String writeValueAsString(T object) throws JsonProcessingException{
		return mapper.writeValueAsString(object);
	}
	
}
