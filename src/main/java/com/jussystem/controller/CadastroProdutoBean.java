package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import com.jussystem.model.Categoria;
import com.jussystem.model.Produto;
import com.jussystem.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
    @Inject
	private Categorias categorias;
	
	private Produto produto;
	
	private Categoria categoriaPai;
	
	private List<Categoria> categoriasRaizes;
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
 
		categoriasRaizes = categorias.raizes();
	}
	
	
	public void salvar() {
		
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}
	
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}
	
	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

}
