package com.jussystem.controller;

import java.io.Serializable;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.jussystem.model.Estado;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroEstadoService;

@Named
@ViewScoped
public class CadastroEstadoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Estado estado;
	
	@Inject
	private CadastroEstadoService cadastroEstadoService;
	
	public CadastroEstadoBean() {
		limpar();
	}
	
	public void inicializar() {
		
	}
	
	public void salvar() {
		
		estado = cadastroEstadoService.salvar(estado);
		limpar();
		FacesUtil.addInfoMessage("Estado salvo com sucesso!");
		
	}
	
	private void limpar() {
		estado = new Estado();
		
	}
	
	public boolean isEditando() {
		return this.estado.getId() != null;
	}
	
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
