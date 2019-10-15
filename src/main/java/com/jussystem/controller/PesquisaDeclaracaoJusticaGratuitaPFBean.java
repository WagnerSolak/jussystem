package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.DeclaracaoJusticaGratuitaPF;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPF;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaPFFilter;


@Named
@ViewScoped
public class PesquisaDeclaracaoJusticaGratuitaPFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitasPF declaracaoJusticaGratuitasPF;
	
	private DeclaracaoJusticaGratuitaPFFilter filtro;
	
	private List<DeclaracaoJusticaGratuitaPF> declaracaoesPessoaFisicaFiltrados;
	
	
	
	public PesquisaDeclaracaoJusticaGratuitaPFBean(){
		filtro = new DeclaracaoJusticaGratuitaPFFilter();
		declaracaoesPessoaFisicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		declaracaoesPessoaFisicaFiltrados = declaracaoJusticaGratuitasPF.filtrados(filtro);
	}
	
	public DeclaracaoJusticaGratuitaPFFilter getFiltro() {
		return filtro;
	}
	
	public List<DeclaracaoJusticaGratuitaPF> getDeclaracaoesPessoaFisicaFiltrados() {
		return declaracaoesPessoaFisicaFiltrados;
	}
	
}
