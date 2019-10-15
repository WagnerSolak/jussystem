package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.TermoEntrevistaParaDemandaPF;
import com.jussystem.repository.TermoEntrevistaParaDemandasPF;
import com.jussystem.repository.filter.TermoEntrevistaParaDemandaPFFilter;


@Named
@ViewScoped
public class PesquisaTermoEntrevistaParaDemandaPFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TermoEntrevistaParaDemandasPF termoEntrevistaParaDemandasPF;
	
	List<TermoEntrevistaParaDemandaPF> termosEntrevistaParaDemandaFiltrados;
	
	private TermoEntrevistaParaDemandaPFFilter filtro;
	
	
	
	public PesquisaTermoEntrevistaParaDemandaPFBean(){
		filtro = new TermoEntrevistaParaDemandaPFFilter();
	}
	
	public void pesquisar(){
		termosEntrevistaParaDemandaFiltrados = termoEntrevistaParaDemandasPF.filtradas(filtro);
	}
	
	
	
	public TermoEntrevistaParaDemandaPFFilter getFiltro() {
		return filtro;
	}
	
	public List<TermoEntrevistaParaDemandaPF> getTermosEntrevistaParaDemandaFiltrados() {
		return termosEntrevistaParaDemandaFiltrados;
	}
}
