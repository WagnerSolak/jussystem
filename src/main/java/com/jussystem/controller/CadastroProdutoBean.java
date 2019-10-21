package com.jussystem.controller;

import java.io.Serializable;



import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import com.jussystem.model.Produto;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProdutoService;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProdutoService cadastroProdutoService;


	private Produto produto;
	


	public CadastroProdutoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
		
		}
	}

	

	public void limpar() {
		produto = new Produto();
		

	}
	
	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto cadastrado com sucesso!");
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;

	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}

	

}
