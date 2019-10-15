package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.ProcuracaoAdJudiciaPF;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcuracaoAdJudiciaPFService;

@Named
@ViewScoped
public class CadastroProcuracaoAdJudiciaPFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProcuracaoAdJudiciaPF procuracaoAdJudiciaPF;

	@Inject
	private CadastroProcuracaoAdJudiciaPFService cadastroProcuracaoAdJudiciaPFService;

	public CadastroProcuracaoAdJudiciaPFBean() {
		limpar();
	}

	public void inicializar() {
		if (procuracaoAdJudiciaPF == null) {
			limpar();
		}

	}

	public void salvar() {
		procuracaoAdJudiciaPF = cadastroProcuracaoAdJudiciaPFService
				.salvar(procuracaoAdJudiciaPF);
		FacesUtil.addInfoMessage("Procuração do cliente: " + procuracaoAdJudiciaPF.getClientePessoaFisica().getNomePessoa()
				+ ", salva com sucesso!");
		limpar();
	}

	public boolean isEditando() {
		return procuracaoAdJudiciaPF.getId() != null;
	}

	// Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente() {
		return procuracaoAdJudiciaPF.getClientePessoaFisica() == null ? null
				: procuracaoAdJudiciaPF.getClientePessoaFisica()
						.getNomePessoa();

	}

	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o
	// faz
	public void setNomeCliente(String nome) {
	}

	public void clienteSelecionado(SelectEvent evento) {
		procuracaoAdJudiciaPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}

	private void limpar() {
		procuracaoAdJudiciaPF = new ProcuracaoAdJudiciaPF();

	}

	public Date getDataHoje() {
		return new Date();
	}

	public void setProcuracaoAdJudiciaPF(
			ProcuracaoAdJudiciaPF procuracaoAdJudiciaPF) {
		this.procuracaoAdJudiciaPF = procuracaoAdJudiciaPF;
	}

	public ProcuracaoAdJudiciaPF getProcuracaoAdJudiciaPF() {
		return procuracaoAdJudiciaPF;
	}

}
