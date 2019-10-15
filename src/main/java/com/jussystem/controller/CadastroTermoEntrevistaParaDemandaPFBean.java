package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.TermoEntrevistaParaDemandaPF;
import com.jussystem.model.TipoPessoa;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroTermoEntrevistaParaDemandaPFService;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class CadastroTermoEntrevistaParaDemandaPFBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TermoEntrevistaParaDemandaPF termoEntrevistaParaDemandaPF;
	
	@Inject
	private CadastroTermoEntrevistaParaDemandaPFService cadastroTermoEntrevistaParaDemandaService;
	
	public CadastroTermoEntrevistaParaDemandaPFBean(){
		limpar();
	}
	
	public void inicializar() {
		if (termoEntrevistaParaDemandaPF == null) {
			limpar();
		}
	}
	
	public void salvar(){
		try {
			termoEntrevistaParaDemandaPF = cadastroTermoEntrevistaParaDemandaService.salvar(termoEntrevistaParaDemandaPF);
			FacesUtil.addInfoMessage("Entrevista do cliente: " 
						+ termoEntrevistaParaDemandaPF.getClientePessoaFisica().getNomePessoa()
						+", salva com sucesso!");
			limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	
	
	public void clienteSelecionado(SelectEvent evento){
		termoEntrevistaParaDemandaPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}
	
	public boolean isEditando(){
		return termoEntrevistaParaDemandaPF.getId() != null;
	}
	
	public TipoPessoa[] getTipos(){
		return TipoPessoa.values();
		
	}
	
	public Date getDataHoje(){
		return new Date();
	}
	
	public void limpar(){
		this.termoEntrevistaParaDemandaPF = new TermoEntrevistaParaDemandaPF();
		this.termoEntrevistaParaDemandaPF.setTipo(TipoPessoa.FISICA);
	}
	
	public TermoEntrevistaParaDemandaPF getTermoEntrevistaParaDemandaPF() {
		return termoEntrevistaParaDemandaPF;
	}
	
	public void setTermoEntrevistaParaDemandaPF(
			TermoEntrevistaParaDemandaPF termoEntrevistaParaDemandaPF) {
		this.termoEntrevistaParaDemandaPF = termoEntrevistaParaDemandaPF;
	}
	
	// Método para resolver NotFoundException quando cliente não selecionado!
		@NotBlank
		public String getNomeCliente() {
			return termoEntrevistaParaDemandaPF.getClientePessoaFisica() == null ? null
					: termoEntrevistaParaDemandaPF.getClientePessoaFisica()
							.getNomePessoa();

		}

		// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
		// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o
		// faz
		public void setNomeCliente(String nome) {
		}
	
}
