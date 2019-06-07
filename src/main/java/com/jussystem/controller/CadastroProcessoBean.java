package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jussystem.model.NaturezaProcesso;
import com.jussystem.model.Pessoa;
import com.jussystem.model.Processo;
import com.jussystem.model.StatusProcesso;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProcessoService;

@Named
@ViewScoped
public class CadastroProcessoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Processo processo;

	@Inject
	private CadastroProcessoService processoService;
	
	public CadastroProcessoBean(){
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			
			this.recalcularProcesso();
		
		}
	}

	public void salvar() {
		processo.setStatusProcesso(StatusProcesso.ANDAMENTO);
		processo.setDataEntrada(new Date());
		processo = processoService.salvar(processo);
		limpar();
		FacesUtil.addInfoMessage("Processo salvo com sucesso!");
	}

	public void recalcularProcesso() {
		if(this.processo != null){
			this.processo.recalcularValorLiquido();
		}
	}

	public NaturezaProcesso[] getNaturezasProcesso() {
		return NaturezaProcesso.values();
	}

	public void pessoaSelecionada(SelectEvent event) {
		processo.setPessoa((Pessoa) event.getObject());
	}

	public Date dataHoje() {
		return new Date();
	}

	public void limpar() {
		processo = new Processo();
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Processo getProcesso() {
		return processo;
	}
}
