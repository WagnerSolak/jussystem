package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Pessoa;
import com.jussystem.model.SexoPessoa;
import com.jussystem.model.StatusPessoa;
import com.jussystem.model.TipoPessoa;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroPessoaService;
import com.jusystem.service.NegocioException;


@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPessoaService service;
	
	private Pessoa pessoa;
	
	
	
	public void inicializar() {
		if(pessoa == null) {
			limpar();
		}
	}
	
	public void salvar() {
		try {
			pessoa.setStatus(StatusPessoa.ATIVO);
	
			service.salvar(pessoa);
			limpar();
			FacesUtil.addInfoMessage("Pessoa cadastrada com sucesso!");
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		this.pessoa = new Pessoa();
		this.pessoa.setTipo(TipoPessoa.FISICA);
	}
	
	public Date getDataHoje() {
		return new Date();
	}
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean isEditando() {
		return pessoa != null && pessoa.getId() == null;
	}
	
	public TipoPessoa[] getTipos() {
		return TipoPessoa.values();
	}
	
	public SexoPessoa[] getSexos() {
		return SexoPessoa.values();
	}

}
