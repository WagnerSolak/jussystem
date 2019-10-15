package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;


import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.DeclaracaoJusticaGratuitaPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroDeclaracaoJusticaGratuitaPJService;


@Named
@ViewScoped
public class CadastroDeclaracaoJusticaGratuitaPJBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DeclaracaoJusticaGratuitaPJ declaracaoJusticaGratuitaPJ;
	
	@Inject
	private CadastroDeclaracaoJusticaGratuitaPJService cadastroDeclaracaoJusticaGratuitaPJService;
	
	
	public void inicializar() {
		if (declaracaoJusticaGratuitaPJ == null) {
			limpar();
		}
	}
	
	public void salvar() {
		declaracaoJusticaGratuitaPJ = cadastroDeclaracaoJusticaGratuitaPJService
				.salvar(declaracaoJusticaGratuitaPJ);
		FacesUtil.addInfoMessage("Declaração Justiça Gratuita do cliente: " 
				+declaracaoJusticaGratuitaPJ.getClientePessoaJuridica().getNomeContratante()
				+", salva com sucesso!");
		limpar();
	}
	
	public CadastroDeclaracaoJusticaGratuitaPJBean(){
		limpar();
	}
	
	public void limpar(){
		declaracaoJusticaGratuitaPJ = new DeclaracaoJusticaGratuitaPJ();
	}
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public boolean isEditando(){
		return declaracaoJusticaGratuitaPJ.getId() != null;
	}
	
	public void clienteSelecionado(SelectEvent evento){
		declaracaoJusticaGratuitaPJ.setClientePessoaJuridica((ClientePessoaJuridica) evento.getObject());
	}

	
	public void setDeclaracaoJusticaGratuitaPJ(
			DeclaracaoJusticaGratuitaPJ declaracaoJusticaGratuitaPJ) {
		this.declaracaoJusticaGratuitaPJ = declaracaoJusticaGratuitaPJ;
	}
	
	public DeclaracaoJusticaGratuitaPJ getDeclaracaoJusticaGratuitaPJ() {
		return declaracaoJusticaGratuitaPJ;
	}
	
	//Método para resolver NotFoundException quando cliente não selecionado!
			@NotBlank
			public String getNomeCliente(){
				return declaracaoJusticaGratuitaPJ.getClientePessoaJuridica() == null ? null :
						declaracaoJusticaGratuitaPJ.getClientePessoaJuridica().getNomeContratante();
			}
			
			
			// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
			// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
			public void setNomeCliente(String nome){
			}
	
	
}
