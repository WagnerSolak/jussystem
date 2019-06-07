package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jussystem.model.Pessoa;
import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcuracaoAdJudiciaService;


@Named
@ViewScoped
public class CadastroProcuracaoAdJudiciaBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private ProcuracaoAdJudicia procuracaoAdJudicia;
	
	@Inject
	private CadastroProcuracaoAdJudiciaService cadastroProcuracaoAdJudiciaService;
	
	
	public CadastroProcuracaoAdJudiciaBean(){
		limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			System.out.println("Chamei o IsNotPostBack");
		}

	}
	public void salvar() {
		procuracaoAdJudicia = cadastroProcuracaoAdJudiciaService.salvar(procuracaoAdJudicia);
		
		limpar();
		FacesUtil.addInfoMessage("Procuração salva com sucesso");
	}
	
	public boolean isEditando(){
		return procuracaoAdJudicia.getId() != null;
	}
	
	
	public void pessoaSelecionada(SelectEvent event){
		procuracaoAdJudicia.setPessoa((Pessoa) event.getObject());
	}
	private void limpar() {
		procuracaoAdJudicia = new ProcuracaoAdJudicia();
		
	}
	
	public Date getDataHoje() {
		return new Date();
	}
	

	public void setProcuracaoAdJudicia(ProcuracaoAdJudicia procuracaoAdJudicia) {
		this.procuracaoAdJudicia = procuracaoAdJudicia;
	}
	
	public ProcuracaoAdJudicia getProcuracaoAdJudicia() {
		return procuracaoAdJudicia;
	}
	
	
	
}
