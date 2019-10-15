package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.TermoEntrevistaParaDemandaPJ;
import com.jussystem.repository.TermoEntrevistaParaDemandasPJ;
import com.jussystem.repository.filter.TermoEntrevistaParaDemandaPJFilter;


@Named
@ViewScoped
public class PesquisaTermoEntrevistaParaDemandaPJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TermoEntrevistaParaDemandasPJ termoEntrevistaParaDemandasPJ;
	
	List<TermoEntrevistaParaDemandaPJ> termosEntrevistaParaDemandaFiltrados;
	
	private TermoEntrevistaParaDemandaPJFilter filtro;
	
	public PesquisaTermoEntrevistaParaDemandaPJBean(){
		filtro = new TermoEntrevistaParaDemandaPJFilter();
	}
	
	public void pesquisar(){
		termosEntrevistaParaDemandaFiltrados = termoEntrevistaParaDemandasPJ.filtradas(filtro);
	}
	
	public TermoEntrevistaParaDemandaPJFilter getFiltro() {
		return filtro;
	}
	
	public List<TermoEntrevistaParaDemandaPJ> getTermosEntrevistaParaDemandaFiltrados() {
		return termosEntrevistaParaDemandaFiltrados;
	}
}
