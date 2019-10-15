package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.jussystem.model.Categoria;
import com.jussystem.model.Produto;
import com.jussystem.repository.Categorias;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProdutoService;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;

	@Inject
	private CadastroProdutoService cadastroProdutoService;


	private Produto produto;
	
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			categoriasRaizes = categorias.raizes();

			if (this.categoriaPai != null) {
				carregarSubcategorias();

			}

		}
	}

	public void carregarSubcategorias() {
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}

	

	public void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();

	}
	
	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		carregarSubcategorias();
		FacesUtil.addInfoMessage("Produto cadastrado com sucesso!");
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;

		if (this.produto != null) {
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}

	

}
