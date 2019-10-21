package com.jussystem.controller;

import com.jussystem.model.ProcessoPJ;

public class ProcessoPJAlteradoEvent {

	private ProcessoPJ processoPJ;
	
	public ProcessoPJAlteradoEvent(ProcessoPJ processoPJ){
		this.processoPJ = processoPJ;
	}
	
	public ProcessoPJ getProcessoPJ() {
		return processoPJ;
	}
}
