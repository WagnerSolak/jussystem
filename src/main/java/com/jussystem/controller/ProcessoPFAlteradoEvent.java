package com.jussystem.controller;

import com.jussystem.model.ProcessoPF;

public class ProcessoPFAlteradoEvent {

	private ProcessoPF processoPF;
	
	public ProcessoPFAlteradoEvent(ProcessoPF processoPF){
		this.processoPF = processoPF;
	}
	
	public ProcessoPF getProcessoPF() {
		return processoPF;
	}
}
