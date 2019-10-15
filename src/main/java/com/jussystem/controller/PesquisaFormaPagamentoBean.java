package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.FormaPagamento;
import com.jussystem.repository.FormaPagamentos;
import com.jussystem.repository.filter.FormaPagamentoFilter;

@Named
@ViewScoped
public class PesquisaFormaPagamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FormaPagamentos formaPagamentos;
	
	private FormaPagamentoFilter filtro;
	
	private List<FormaPagamento> formaPagamentoFiltrados;
	
	public PesquisaFormaPagamentoBean() {
		filtro = new FormaPagamentoFilter();
	}
	
	public void pesquisar() {
		formaPagamentoFiltrados = formaPagamentos.filtrados(filtro);
	}
	
	
	public List<FormaPagamento> getFormaPagamentoFiltrados() {
		return formaPagamentoFiltrados;
	}
	
	public FormaPagamentoFilter getFiltro() {
		return filtro;
	}
	
}
