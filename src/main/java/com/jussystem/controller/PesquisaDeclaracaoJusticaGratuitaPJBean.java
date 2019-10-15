package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.DeclaracaoJusticaGratuitaPJ;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPJ;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaPJFilter;


@Named
@ViewScoped
public class PesquisaDeclaracaoJusticaGratuitaPJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitasPJ declaracaoJusticaGratuitasPJ;
	
	private DeclaracaoJusticaGratuitaPJFilter filtro;
	
	private List<DeclaracaoJusticaGratuitaPJ> declaracoesPessoaJuridicaFiltrados;
	
	
	public PesquisaDeclaracaoJusticaGratuitaPJBean(){
		filtro = new DeclaracaoJusticaGratuitaPJFilter();
		declaracoesPessoaJuridicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		declaracoesPessoaJuridicaFiltrados = declaracaoJusticaGratuitasPJ.filtrados(filtro);
	}
	
	public DeclaracaoJusticaGratuitasPJ getDeclaracaoJusticaGratuitasPJ() {
		return declaracaoJusticaGratuitasPJ;
	}
	
	public List<DeclaracaoJusticaGratuitaPJ> getDeclaracoesPessoaJuridicaFiltrados() {
		return declaracoesPessoaJuridicaFiltrados;
	}
	
	public DeclaracaoJusticaGratuitaPJFilter getFiltro() {
		return filtro;
	}
	
}
