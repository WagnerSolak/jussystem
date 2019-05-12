package com.jussystem.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Produto;
import com.jussystem.repository.Produtos;
import com.jussystem.repository.filter.ProdutoFilter;
import com.jussystem.util.jsf.FacesUtil;

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
	
	/*public void testeImprimeConsole() {
		System.out.println("ID: " + produtoSelecionado.getId());
		System.out.println("Nome: "+ produtoSelecionado.getNome());
	}*/
	
	public void excluir() {
		
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		//System.out.println("Id: " + produtoSelecionado.getId()+ "nome: " + produtoSelecionado.getNome());
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getNome() + " excluído com sucesso!");
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

