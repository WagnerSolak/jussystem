package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.ContratoHonorarioAdvocaticioPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroContratoHonorarioAdvocaticioPJService;

@Named
@ViewScoped
public class CadastroContratoHonorarioAdvocaticioPJBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContratoHonorarioAdvocaticioPJ contratoHonorarioAdvocaticioPJ;

	@Inject
	private CadastroContratoHonorarioAdvocaticioPJService cadastroContratoHonorarioAdvocaticioPJService;
	
	
	public CadastroContratoHonorarioAdvocaticioPJBean(){
		limpar();
	}
	
	public void inicializar() {
		if (contratoHonorarioAdvocaticioPJ == null) {
			limpar();
		}
	}
	
	public void limpar(){
		contratoHonorarioAdvocaticioPJ = new ContratoHonorarioAdvocaticioPJ();
	}
	
	public void salvar(){
		contratoHonorarioAdvocaticioPJ = cadastroContratoHonorarioAdvocaticioPJService.salvar(contratoHonorarioAdvocaticioPJ);
		FacesUtil.addInfoMessage("Contrato Honorário Advocatício do cliente: " 
				+contratoHonorarioAdvocaticioPJ.getClientePessoaJuridica().getNomeContratante()
				+", com CÓDIGO: "
				+contratoHonorarioAdvocaticioPJ.getId()
				+", salvo com sucesso!");
		limpar();
	}
	
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public boolean isEditando(){
		return this.contratoHonorarioAdvocaticioPJ.getId() != null;
	}
	
	public void clienteSelecionado(SelectEvent evento){
		contratoHonorarioAdvocaticioPJ.setClientePessoaJuridica((ClientePessoaJuridica) evento.getObject());
	}
	
	//Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente(){
		return contratoHonorarioAdvocaticioPJ.getClientePessoaJuridica() == null ? null :
			contratoHonorarioAdvocaticioPJ.getClientePessoaJuridica().getNomeContratante();
	}
	
	
	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
	public void setNomeCliente(String nome){
	}
	
	public void setContratoHonorarioAdvocaticioPJ(
			ContratoHonorarioAdvocaticioPJ contratoHonorarioAdvocaticioPJ) {
		this.contratoHonorarioAdvocaticioPJ = contratoHonorarioAdvocaticioPJ;
	}
	
	public ContratoHonorarioAdvocaticioPJ getContratoHonorarioAdvocaticioPJ() {
		return contratoHonorarioAdvocaticioPJ;
	}
}
