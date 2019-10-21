package com.jussystem.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcessoPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CancelamentoProcessoPJService;

@Named
@RequestScoped
public class CancelamentoProcessoPJBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CancelamentoProcessoPJService cancelamentoProcessoPJService;
	
	@Inject
	private Event<ProcessoPJAlteradoEvent> processoPJAlteradoEvent;
	
	@Inject
	@ProcessoPJEdicao
	private ProcessoPJ processoPJ;
	
	public void cancelarProcesso(){
		this.processoPJ = this.cancelamentoProcessoPJService.cancelar(this.processoPJ);
		this.processoPJAlteradoEvent.fire(new ProcessoPJAlteradoEvent(this.processoPJ));
		
		FacesUtil.addInfoMessage("Processo: "+processoPJ.getNumeroProcesso() +", do cliente: " + processoPJ.getClientePessoaJuridica().getNomeContratante() +", cancelado com sucesso!");
	}
}
