package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.ContratoHonorarioAdvocaticioPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroContratoHonorarioAdvocaticioPFService;


@Named
@ViewScoped
public class CadastroContratoHonorarioAdvocaticioPFBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private ContratoHonorarioAdvocaticioPF contratoHonorarioAdvocaticioPF;
	
	@Inject
	private CadastroContratoHonorarioAdvocaticioPFService contratoHonorarioAdvocaticioPFService;
	
	public CadastroContratoHonorarioAdvocaticioPFBean(){
		limpar();
	}
	
	public void inicializar() {
		if (contratoHonorarioAdvocaticioPF == null) {
			limpar();
		}
	}
	
	public void limpar(){
		contratoHonorarioAdvocaticioPF = new ContratoHonorarioAdvocaticioPF();
	}
	
	public void salvar(){
		contratoHonorarioAdvocaticioPF = contratoHonorarioAdvocaticioPFService.salvar(contratoHonorarioAdvocaticioPF);
		FacesUtil.addInfoMessage("Contrato Honorário Advocatício do cliente: " 
				+contratoHonorarioAdvocaticioPF.getClientePessoaFisica().getNomePessoa()
				+", salvo com sucesso!");
		limpar();
	}
	
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public boolean isEditando(){
		return this.contratoHonorarioAdvocaticioPF.getId() != null;
	}
	
	public void clienteSelecionado(SelectEvent evento){
		contratoHonorarioAdvocaticioPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}
	
	public void setContratoHonorarioAdvocaticioPF(
			ContratoHonorarioAdvocaticioPF contratoHonorarioAdvocaticioPF) {
		this.contratoHonorarioAdvocaticioPF = contratoHonorarioAdvocaticioPF;
	}
	
	public ContratoHonorarioAdvocaticioPF getContratoHonorarioAdvocaticioPF() {
		return contratoHonorarioAdvocaticioPF;
	}
	
	//Método para resolver NotFoundException quando cliente não selecionado!
			@NotBlank
			public String getNomeCliente(){
				return contratoHonorarioAdvocaticioPF.getClientePessoaFisica() == null ? null :
					contratoHonorarioAdvocaticioPF.getClientePessoaFisica().getNomePessoa();
			}
			
			
			// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
			// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
			public void setNomeCliente(String nome){
			}
}
