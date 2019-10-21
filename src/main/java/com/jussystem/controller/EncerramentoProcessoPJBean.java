package com.jussystem.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcessoPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.EdicaoProcessoPJService;


@Named
@RequestScoped
public class EncerramentoProcessoPJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Event<ProcessoPJAlteradoEvent> processoPJAlteradoEvent;
	
	@Inject
	private EdicaoProcessoPJService edicaoProcessoPJService;
	
	@Inject
	@ProcessoPJEdicao
	private ProcessoPJ processoPJ;
	
	public void encerrarProcesso(){
		try{

			if(processoPJ.isValorTotalNaoAceito()){
				FacesUtil.addErrorMessage("Processo não pode ser encerrado sem Valor Total *");
			}
			
			
			if(processoPJ.isPercentualNaoAceito()){
				FacesUtil.addErrorMessage("Processo não pode ser encerrado sem Percentual *");
			}
			else{
				this.processoPJ = this.edicaoProcessoPJService.encerrar(this.processoPJ);
				this.processoPJAlteradoEvent.fire(new ProcessoPJAlteradoEvent(this.processoPJ));
				
			
				FacesUtil.addInfoMessage("Processo: "+processoPJ.getNumeroProcesso() +", do cliente: " 
				+ processoPJ.getClientePessoaJuridica().getNomeContratante() +", encerrado com sucesso!");
			}
				
		
			
		}catch(Exception e){
			e.getMessage();
	}
}
}
