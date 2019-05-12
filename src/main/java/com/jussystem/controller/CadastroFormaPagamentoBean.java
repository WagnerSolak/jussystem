package com.jussystem.controller;

import java.io.Serializable;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.FormaPagamento;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroFormaPagamentoService;


@Named
@ViewScoped
public class CadastroFormaPagamentoBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	private FormaPagamento formaPagamento;
	
	public CadastroFormaPagamentoBean() {
		limpar();
	}
	
	public void salvar() {
		formaPagamento= cadastroFormaPagamentoService.salvar(formaPagamento);
		limpar();
		FacesUtil.addInfoMessage("Forma de pagamento cadastrada com sucesso!");
	}
	
	public void inicializar() {
	
	}
	
	public boolean isEditando() {
		return this.formaPagamento.getId() != null;
	}
	
	private void limpar() {
		formaPagamento = new FormaPagamento();
	}

	public FormaPagamento getFormaPagamento() {
		if(formaPagamento == null) {
			formaPagamento = new FormaPagamento();
		}
		return formaPagamento;
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
