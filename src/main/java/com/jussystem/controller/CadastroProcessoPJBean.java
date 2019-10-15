package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.NaturezaProcesso;
import com.jussystem.model.ProcessoPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcessoPJService;


@Named
@ViewScoped
public class CadastroProcessoPJBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProcessoPJ processoPJ;
	
	@Inject
	private CadastroProcessoPJService cadastroProcessoPJService;
	
	public CadastroProcessoPJBean(){
		limpar();
	}
	
	public void limpar(){
		processoPJ = new ProcessoPJ();
		this.processoPJ.setNaturezaProcesso(NaturezaProcesso.TRABALHO);
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
				this.recalcularProcesso();
		}
	}
	
	public void salvar(){
		processoPJ = cadastroProcessoPJService.salvar(processoPJ);
		FacesUtil.addInfoMessage("Processo: " + processoPJ.getNumeroProcesso() 
				+ " salvo com sucesso!");
		limpar();
		
	}
	
public void recalcularProcesso() {
		
		if(this.processoPJ != null){
			if(processoPJ.getNaturezaProcesso().equals(NaturezaProcesso.TRABALHO)){
				this.processoPJ.recalcularValorLiquido();
			}else{
				this.processoPJ.recalcularValorLiquidoCivil();
			}
			
		}
	}
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public void clienteSelecionado(SelectEvent evento){
		processoPJ.setClientePessoaJuridica((ClientePessoaJuridica) evento.getObject());
	}

	public Date dataHoje() {
		return new Date();
	}
	
	public NaturezaProcesso[] getNaturezasProcesso(){
		return NaturezaProcesso.values();
	}
	
	//Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente(){
		return processoPJ.getClientePessoaJuridica() == null ? null :
			processoPJ.getClientePessoaJuridica().getNomeContratante();
	}
	
	
	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
	public void setNomeCliente(String nome){
	}

	
	public ProcessoPJ getProcessoPJ() {
		return processoPJ;
	}
	
	public void setProcessoPJ(ProcessoPJ processoPJ) {
		this.processoPJ = processoPJ;
	}
}
