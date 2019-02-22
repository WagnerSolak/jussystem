package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.jussystem.model.Cidade;
import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroCidadeService;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCidadeService cadastroCidadeService;
	
	@Inject
	private Estados estadosRepository;
	
	private Cidade cidade;
	private Estado estado;
	private List<Estado> estados;
	
	
	public CadastroCidadeBean() {
		limpar();
		
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			estados = estadosRepository.buscarEstados();
		}
		
			
	}
	
	public void salvar() {
		cadastroCidadeService.salvar(cidade);
		limpar();
		FacesUtil.addInfoMessage("Cidade cadastrada com sucesso!");
		
	}	
	
	public void limpar() {
		cidade = new Cidade();
		estado = null;
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
