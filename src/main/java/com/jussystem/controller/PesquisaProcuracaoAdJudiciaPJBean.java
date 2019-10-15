package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcuracaoAdJudiciaPJ;
import com.jussystem.repository.ProcuracaoAdJudiciasPJ;
import com.jussystem.repository.filter.ProcuracaoAdJudiciaPJFilter;


@Named
@ViewScoped
public class PesquisaProcuracaoAdJudiciaPJBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudiciasPJ procuracaoAdJudiciasPJ;
	
	List<ProcuracaoAdJudiciaPJ> procuracoesAdJudiciaPessoaJuridicasFiltradas;
	
	private ProcuracaoAdJudiciaPJFilter filtro;
	
	
	public PesquisaProcuracaoAdJudiciaPJBean(){
		filtro = new ProcuracaoAdJudiciaPJFilter();
	}
	
	public void pesquisar(){
		procuracoesAdJudiciaPessoaJuridicasFiltradas = procuracaoAdJudiciasPJ.filtradas(filtro);
	}
	
	public ProcuracaoAdJudiciaPJFilter getFiltro() {
		return filtro;
	}
	
	public List<ProcuracaoAdJudiciaPJ> getProcuracoesAdJudiciaPessoaJuridicasFiltradas() {
		return procuracoesAdJudiciaPessoaJuridicasFiltradas;
	}
}
