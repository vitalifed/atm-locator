package com.backbase.assignment.solution.flow;

import com.backbase.assignment.solution.util.Processor;

public enum Flow {

	ING(Processor.SEARCH), INGR(Processor.RAW);
	
	private Processor processor;
	
	Flow(Processor proc){
		processor = proc;
	}
	
	public Processor getProcessor() {
		return processor;
	}
	
}
