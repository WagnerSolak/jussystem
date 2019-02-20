package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.jussystem.model.Cidade;
import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estados estadosRepository;
	
	private Cidade cidade;
	
	private List<Estado> estados;
	
	private Estado est;
	
	public void inicializar() {
		System.out.println("Inicializando...");
		estados = estadosRepository.buscarEstados();
			
	}
	
	public void salvar() {
		System.out.println("Estado selecioado: " + est.getNome());
		System.out.println("Silga Estado: " + est.getSigla());
	}
	
	
	public CadastroCidadeBean() {
		cidade = new Cidade();
		est = new Estado();
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEst(Estado est) {
		this.est = est;
	}
	
	public Estado getEst() {
		return est;
	}

}
