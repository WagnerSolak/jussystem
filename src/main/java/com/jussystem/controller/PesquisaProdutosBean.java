package com.jussystem.controller;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Produto;
import com.jussystem.repository.Produtos;
import com.jussystem.repository.filter.ProdutoFilter;


@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private List<Produto>produtosFiltrados;
	
	@Inject
	private Produtos produtos;
	
	private ProdutoFilter filtro;
	
	private Produto produtoSelecionado;
	
	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	
	
	public Date getDataHoje() {
		return new Date();
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}
	
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	
}

