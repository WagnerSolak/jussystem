package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.jussystem.model.Cidade;
import com.jussystem.model.Estado;
import com.jussystem.repository.Cidades;
import com.jussystem.repository.Estados;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cidades cidades;
	
	@Inject
	private Estados estadosRepository;
	
	private Cidade cidade;
	private Estado estado;
	private List<Estado> estados;
	
	
	public CadastroCidadeBean() {
		limpar();
		
	}
	
	public void inicializar() {
		System.out.println("Inicializando...");
		estados = estadosRepository.buscarEstados();
			
	}
	
	public void salvar() {
		System.out.println("Nome da cidade informada: " + cidade.getNome());
		System.out.println("Estado selecionado foi: " + cidade.getEstado());
		System.out.println("Estado: " + estado.getNome());
		System.out.println("Estado: " + estado.getSigla());
		System.out.println("Estado: " + estado.getId());
	}
	
	public void limpar() {
		cidade = new Cidade();
		estado = new Estado();
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
