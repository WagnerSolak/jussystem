package com.jussystem.controller;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcessoPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CancelamentoProcessoPFService;

@Named
@RequestScoped
public class CancelamentoProcessoPFBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CancelamentoProcessoPFService cancelamentoProcessoPFService;
	
	@Inject
	private Event<ProcessoPFAlteradoEvent> processoPFAlteradoEvent;
	
	@Inject
	@ProcessoPFEncerramento
	private ProcessoPF processoPF;
	
	public void cancelarProcesso(){
		this.processoPF = this.cancelamentoProcessoPFService.cancelar(this.processoPF);
		this.processoPFAlteradoEvent.fire(new ProcessoPFAlteradoEvent(this.processoPF));
		
		FacesUtil.addInfoMessage("Processo: "+processoPF.getNumeroProcesso() +", do cliente: " + processoPF.getClientePessoaFisica().getNomePessoa() +", cancelado com sucesso!");
	}
}
