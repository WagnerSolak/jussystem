package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.repository.filter.MovimentoSaidaProdutoFilter;


@Named
@ViewScoped
public class PesquisaMovimentoSaidaDeProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovimentoSaidaProdutos movimentoSaidaProdutos;
	
	private MovimentoSaidaProdutoFilter filtro;
	
	private List<MovimentoSaidaProduto> movimentosFiltrados;
	
	
	public PesquisaMovimentoSaidaDeProdutoBean(){
		filtro = new MovimentoSaidaProdutoFilter();
	}
	
	public void pesquisar(){
		movimentosFiltrados = movimentoSaidaProdutos.filtradas(filtro);
	}
	
	
	
	public MovimentoSaidaProdutoFilter getFiltro() {
		return filtro;
	}
	
	
	public List<MovimentoSaidaProduto> getMovimentosFiltrados() {
		return movimentosFiltrados;
	}
	
	
}
