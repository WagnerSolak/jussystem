package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ProcuracaoAdJudiciaPF;
import com.jussystem.repository.ProcuracaoAdJudiciasPF;
import com.jussystem.repository.filter.ProcuracaoAdJudiciaPFFilter;

@Named
@ViewScoped
public class PesquisaProcuracaoAdJudiciaPFBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudiciasPF procuracaoAdJudiciasPF;
	
	List<ProcuracaoAdJudiciaPF> procuracoesAdJudiciaPessoaFisicaFiltradas;
	
	private ProcuracaoAdJudiciaPFFilter filtro;
	
	public PesquisaProcuracaoAdJudiciaPFBean(){
		filtro = new ProcuracaoAdJudiciaPFFilter();
	}
	
	public void pesquisar(){
		procuracoesAdJudiciaPessoaFisicaFiltradas = procuracaoAdJudiciasPF.filtradas(filtro);
	}
	
	public List<ProcuracaoAdJudiciaPF> getProcuracoesAdJudiciaPessoaFisicaFiltradas() {
		return procuracoesAdJudiciaPessoaFisicaFiltradas;
	}
	
	public ProcuracaoAdJudiciaPFFilter getFiltro() {
		return filtro;
	}
}
