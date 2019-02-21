package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroEstadoService;

@Named
@ViewScoped
public class CadastroEstadoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estados estados;
	
	private Estado estado;
	
	@Inject
	private CadastroEstadoService cadastroEstadoService;
	
	public CadastroEstadoBean() {
		
	}
	
	public void inicializar() {
		limpar();
	}
	
	
	public void salvar() {
		estado = cadastroEstadoService.salvar(estado);
		limpar();
		FacesUtil.addInfoMessage("Estado salvo com sucesso!");
		
	}
	
	private void limpar() {
		estado = new Estado();
		
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
