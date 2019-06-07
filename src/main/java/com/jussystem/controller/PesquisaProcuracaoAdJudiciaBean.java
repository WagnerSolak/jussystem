package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.repository.ProcuracaoAdJudicias;
import com.jussystem.repository.filter.ProcuracaoAdJudiciaFilter;

@Named
@ViewScoped
public class PesquisaProcuracaoAdJudiciaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudicias procuracaoAdJudicias;
	
	List<ProcuracaoAdJudicia> procuracoesAdJudiciaFiltradas;
	
	private ProcuracaoAdJudiciaFilter filtro;
	
	public PesquisaProcuracaoAdJudiciaBean(){
		filtro = new ProcuracaoAdJudiciaFilter();
	}
	
	public void pesquisar(){
		procuracoesAdJudiciaFiltradas = procuracaoAdJudicias.filtradas(filtro);
	}
	
	public List<ProcuracaoAdJudicia> getProcuracoesAdJudiciaFiltradas() {
		return procuracoesAdJudiciaFiltradas;
	}
	
	public ProcuracaoAdJudiciaFilter getFiltro() {
		return filtro;
	}
}
