package com.jussystem.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcessoPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.EncerramentoProcessoPFService;


@Named
@RequestScoped
public class EncerramentoProcessoPFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Event<ProcessoPFAlteradoEvent> processoPFAlteradoEvent;
	
	@Inject
	private EncerramentoProcessoPFService encerramentoProcessoPFService;
	
	@Inject
	@ProcessoPFEncerramento
	private ProcessoPF processoPF;
	
	
	public void encerrarProcesso(){
		try{
			
			if(processoPF.isNaoEncerravelZerado()){
				FacesUtil.addErrorMessage("Processo não pode ser encerrado sem Valor Total * !");
			}
			
			if(processoPF.isNaoEncerravelPercentualZerado()){
				FacesUtil.addErrorMessage("Processo não pode ser encerrado sem Percentual * !");
			}
			
				this.processoPF = this.encerramentoProcessoPFService.encerrar(this.processoPF);
				//lançar evento CDI para atualizar a tela
				this.processoPFAlteradoEvent.fire(new ProcessoPFAlteradoEvent(this.processoPF));
				
				FacesUtil.addInfoMessage("Processo: "+processoPF.getNumeroProcesso() +", do cliente: " + processoPF.getClientePessoaFisica().getNomePessoa() +", encerrado com sucesso!");
			
			
		}catch(Exception e){
			e.getMessage();
			
			
		}
	}
}
