package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.ProcuracaoAdJudiciaPJ;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcuracaoAdJudiciaPJService;

@Named
@ViewScoped
public class CadastroProcuracaoAdJudiciaPJBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProcuracaoAdJudiciaPJ procuracaoAdJudiciaPJ;

	@Inject
	private CadastroProcuracaoAdJudiciaPJService cadastroProcuracaoAdJudiciaPJService;

	public CadastroProcuracaoAdJudiciaPJBean() {
		limpar();
	}
	
	public void inicializar() {
		if (procuracaoAdJudiciaPJ == null) {
			limpar();
		}

	}

	public void limpar() {
		procuracaoAdJudiciaPJ = new ProcuracaoAdJudiciaPJ();
	}

	public void salvar() {
		procuracaoAdJudiciaPJ = cadastroProcuracaoAdJudiciaPJService.salvar(procuracaoAdJudiciaPJ);
		FacesUtil.addInfoMessage("Procuração do cliente: "
				+ procuracaoAdJudiciaPJ.getClientePessoaJuridica()
						.getNomeContratante() + ", salva com sucesso!");
		limpar();
	}

	public Date getDataHoje() {
		return new Date();
	}

	public boolean isEditando() {
		return procuracaoAdJudiciaPJ.getId() != null;
	}

	// Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente() {
		return procuracaoAdJudiciaPJ.getClientePessoaJuridica() == null ? null
				: procuracaoAdJudiciaPJ.getClientePessoaJuridica()
						.getNomeContratante();

	}

	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o
	// faz
	public void setNomeCliente(String nome) {
	}

	public void clienteSelecionado(SelectEvent evento) {
		procuracaoAdJudiciaPJ
				.setClientePessoaJuridica((ClientePessoaJuridica) evento
						.getObject());
	}

	public void setProcuracaoAdJudiciaPJ(
			ProcuracaoAdJudiciaPJ procuracaoAdJudiciaPJ) {
		this.procuracaoAdJudiciaPJ = procuracaoAdJudiciaPJ;
	}

	public ProcuracaoAdJudiciaPJ getProcuracaoAdJudiciaPJ() {
		return procuracaoAdJudiciaPJ;
	}
}
