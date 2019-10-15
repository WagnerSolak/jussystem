package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.repository.MotivoSaidaProdutos;
import com.jussystem.repository.filter.MotivoSaidaProdutoFilter;

@Named
@ViewScoped
public class PesquisaMotivoSaidaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotivoSaidaProdutos motivoSaidaProdutos;
	
	private MotivoSaidaProdutoFilter filtro;
	
	private List<MotivoSaidaProduto> motivoFiltrados;
	
	
	
	public PesquisaMotivoSaidaProdutoBean(){
		filtro = new MotivoSaidaProdutoFilter();
	}
	
	public void pesquisar(){
		motivoFiltrados = motivoSaidaProdutos.filtradas(filtro);
	}
	
	public MotivoSaidaProdutoFilter getFiltro() {
		return filtro;
	}
	
	public List<MotivoSaidaProduto> getMotivoFiltrados() {
		return motivoFiltrados;
	}
}
