package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.DeclaracaoJusticaGratuitaPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroDeclaracaoJusticaGratuitaPFService;

@Named
@ViewScoped
public class CadastroDeclaracaoJusticaGratuitaPFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DeclaracaoJusticaGratuitaPF declaracaoJusticaGratuitaPF;

	@Inject
	private CadastroDeclaracaoJusticaGratuitaPFService cadastroDeclaracaoJusticaGratuitaPFService;

	
	public CadastroDeclaracaoJusticaGratuitaPFBean(){
		limpar();
	}
	
	public void inicializar() {
		if (declaracaoJusticaGratuitaPF == null) {
			limpar();
		}
	}
	
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public boolean isEditando(){
		return this.declaracaoJusticaGratuitaPF.getId() != null;
	}

	public void salvar() {
		declaracaoJusticaGratuitaPF = cadastroDeclaracaoJusticaGratuitaPFService
				.salvar(declaracaoJusticaGratuitaPF);
		FacesUtil.addInfoMessage("Declaração Justiça Gratuita do cliente: " 
				+ declaracaoJusticaGratuitaPF.getClientePessoaFisica().getNomePessoa()
				+ ", com CÓDIGO: "
				+ declaracaoJusticaGratuitaPF.getId()
				+", salva com sucesso!");
		limpar();
	}


	public void clienteSelecionado(SelectEvent evento){
		declaracaoJusticaGratuitaPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}

	public void limpar() {
		declaracaoJusticaGratuitaPF = new DeclaracaoJusticaGratuitaPF();
	}

	public void setDeclaracaoJusticaGratuitaPF(
			DeclaracaoJusticaGratuitaPF declaracaoJusticaGratuitaPF) {
		this.declaracaoJusticaGratuitaPF = declaracaoJusticaGratuitaPF;
	}
	
	public DeclaracaoJusticaGratuitaPF getDeclaracaoJusticaGratuitaPF() {
		return declaracaoJusticaGratuitaPF;
	}
	
		//Método para resolver NotFoundException quando cliente não selecionado!
		@NotBlank
		public String getNomeCliente(){
			return declaracaoJusticaGratuitaPF.getClientePessoaFisica() == null ? null :
					declaracaoJusticaGratuitaPF.getClientePessoaFisica().getNomePessoa();
		}
		
		
		// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
		// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
		public void setNomeCliente(String nome){
		}
	

}
