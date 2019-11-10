package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.TermoEntrevistaParaDemandaPJ;
import com.jussystem.model.TipoPessoa;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroTermoEntrevistaParaDemandaPJService;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class CadastroTermoEntrevistaParaDemandaPJBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TermoEntrevistaParaDemandaPJ termoEntrevistaParaDemandaPJ;

	@Inject
	private CadastroTermoEntrevistaParaDemandaPJService cadastroTermoEntrevistaParaDemandaPJService;

	public CadastroTermoEntrevistaParaDemandaPJBean() {
		limpar();
	}

	public void inicializar() {
		if (termoEntrevistaParaDemandaPJ == null) {
			limpar();
		}
	}

	public void salvar() {
		try {
			termoEntrevistaParaDemandaPJ = cadastroTermoEntrevistaParaDemandaPJService
					.salvar(termoEntrevistaParaDemandaPJ);
			FacesUtil.addInfoMessage("Entrevista do cliente: "
					+ termoEntrevistaParaDemandaPJ.getClientePessoaJuridica()
							.getNomeContratante()
					+ ", com CÓDIGO: "
					+ termoEntrevistaParaDemandaPJ.getId()
					+ ", salva com sucesso!");
			limpar();

		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public void limpar() {
		this.termoEntrevistaParaDemandaPJ = new TermoEntrevistaParaDemandaPJ();
		this.termoEntrevistaParaDemandaPJ.setTipo(TipoPessoa.FISICA);
	}

	public void clienteSelecionado(SelectEvent evento) {
		termoEntrevistaParaDemandaPJ
				.setClientePessoaJuridica((ClientePessoaJuridica) evento
						.getObject());
	}

	public boolean isEditando() {
		return termoEntrevistaParaDemandaPJ.getId() != null;
	}

	public TipoPessoa[] getTipos() {
		return TipoPessoa.values();

	}

	public Date getDataHoje() {
		return new Date();
	}

	// Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente() {
		return termoEntrevistaParaDemandaPJ.getClientePessoaJuridica() == null ? null
				: termoEntrevistaParaDemandaPJ.getClientePessoaJuridica()
						.getNomeContratante();
	}

	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o
	// faz
	public void setNomeCliente(String nome) {
	}

	public void setTermoEntrevistaParaDemandaPJ(
			TermoEntrevistaParaDemandaPJ termoEntrevistaParaDemandaPJ) {
		this.termoEntrevistaParaDemandaPJ = termoEntrevistaParaDemandaPJ;
	}

	public TermoEntrevistaParaDemandaPJ getTermoEntrevistaParaDemandaPJ() {
		return termoEntrevistaParaDemandaPJ;
	}

}
