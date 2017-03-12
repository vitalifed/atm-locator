package com.backbase.assignment.solution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.assignment.solution.util.JsonRawResponseProcessor;
import com.backbase.assignment.solution.util.JsonResponseProcessor;
import com.backbase.assignment.solution.util.Processor;
import com.backbase.assignment.solution.util.ResponseProcessor;

@Component
public class ProcessorFactory {

	
	@Autowired
	private JsonResponseProcessor responseProcessor;
	
	@Autowired
	private JsonRawResponseProcessor responseRawProcessor;

	
	public ResponseProcessor processor(Processor processor){
	
		switch (processor) {
		case SEARCH:
			return responseProcessor;
		default:
			return responseRawProcessor;
		}
	}
	
}
