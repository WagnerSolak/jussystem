package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;










import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.NaturezaProcesso;
import com.jussystem.model.ProcessoPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcessoPFService;

@Named
@ViewScoped
public class CadastroProcessoPFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@ProcessoPFEncerramento
	private ProcessoPF processoPF;

	@Inject
	private CadastroProcessoPFService processoService;
	
	public CadastroProcessoPFBean(){
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			this.recalcularProcesso();
			
		}
	}

	public void salvar() {
		
		processoPF = processoService.salvar(processoPF);
		FacesUtil.addInfoMessage("Processo: " + processoPF.getNumeroProcesso() 
				+ " salvo com sucesso!");
		
	}

	public void recalcularProcesso() {
		
		if(this.processoPF != null){
			if(processoPF.getNaturezaProcesso().equals(NaturezaProcesso.TRABALHO)){
				this.processoPF.recalcularValorLiquido();
			}else{
				this.processoPF.recalcularValorLiquidoCivil();
			}
			
		}
	}
	
	public void processoPFAlterado(@Observes ProcessoPFAlteradoEvent event){
		this.processoPF = event.getProcessoPF();
		
	}
	
	public Date getDataHoje() {
		return new Date();
	}

	public NaturezaProcesso[] getNaturezasProcesso() {
		return NaturezaProcesso.values();
	}

	public void clienteSelecionado(SelectEvent evento){
		processoPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}

	public Date dataHoje() {
		return new Date();
	}

	public void limpar() {
		processoPF = new ProcessoPF();
		this.processoPF.setNaturezaProcesso(NaturezaProcesso.TRABALHO);
		
	}
	
	//Método para resolver NotFoundException quando cliente não selecionado!
			@NotBlank
			public String getNomeCliente(){
				return processoPF.getClientePessoaFisica() == null ? null :
					processoPF.getClientePessoaFisica().getNomePessoa();
			}
			
			
			// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
			// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
			public void setNomeCliente(String nome){
			}

	public void setProcessoPF(ProcessoPF processoPF) {
		this.processoPF = processoPF;
	}
	
	public ProcessoPF getProcessoPF() {
		return processoPF;
	}
}
