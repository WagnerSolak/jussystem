package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;
import com.jussystem.repository.filter.PessoaFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class PesquisaPessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoas pessoas;
	
	private List<Pessoa> pessoasFiltradas;
	private PessoaFilter filtro;
	
	private Pessoa pessoaSelecionada;

	
	public PesquisaPessoaBean() {
		filtro = new PessoaFilter();
	}
	
	
	public void pesquisar() {
		pessoasFiltradas = pessoas.filtradas(filtro);
	}
	
	public void excluir() {
		try {
			pessoas.remover(pessoaSelecionada);
			pessoasFiltradas.remove(pessoaSelecionada);
			
			FacesUtil.addInfoMessage("Pessoa excluída com sucesso!" );
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public List<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}
	
	public PessoaFilter getFiltro() {
		return filtro;
	}
	
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
}