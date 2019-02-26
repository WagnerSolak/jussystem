package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cidade;
import com.jussystem.repository.Cidades;
import com.jussystem.repository.filter.CidadeFilter;
import com.jussystem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCidadeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cidades cidades;
	
	private CidadeFilter filtro;
	private List<Cidade> cidadesFiltradas;
	private Cidade cidadeSelecionada;
	
	public void pesquisar() {
		cidadesFiltradas = cidades.filtradas(filtro);
	}
	
	public PesquisaCidadeBean() {
		filtro = new CidadeFilter();
	}
	
	public void excluir() {
		cidades.remover(cidadeSelecionada);
		cidadesFiltradas.remove(cidadeSelecionada);
		
		FacesUtil.addInfoMessage("A cidade" + cidadeSelecionada.getNome() + "foi excluída com sucesso!");
	}
	
	public CidadeFilter getFiltro() {
		return filtro;
	}
	
	
	public List<Cidade> getCidadesFiltradas() {
		return cidadesFiltradas;
	}
	
	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
	
	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}
}

