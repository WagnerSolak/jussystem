package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Profissao;
import com.jussystem.repository.Profissoes;
import com.jussystem.repository.filter.ProfissaoFilter;


@Named
@ViewScoped
public class PesquisaProfissaoBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private List<Profissao> profissoesFiltradas;
	
	@Inject
	private Profissoes profissoes;
	
	private ProfissaoFilter filtro;
	
	public PesquisaProfissaoBean(){
		filtro = new ProfissaoFilter();
	}
	
	public void pesquisar(){
		profissoesFiltradas = profissoes.filtradas(filtro);
	}
	
	
	
	public ProfissaoFilter getFiltro() {
		return filtro;
	}
	
	public List<Profissao> getProfissoesFiltradas() {
		return profissoesFiltradas;
	}
	
	
}
