package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cargo;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroCargoService;



@Named
@ViewScoped
public class CadastroCargoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCargoService cadastroCargoService;
	
	private Cargo cargo;
	
	public CadastroCargoBean(){
		limpar();
	}
	
	public void inicializar() {
		if(cargo == null){
			limpar();
		}
	}
	
	public void limpar(){
		cargo = new Cargo();
	}
	
	public void salvar() {
		cargo = cadastroCargoService.salvar(cargo);
		FacesUtil.addInfoMessage("Cargo: " +cargo.getCargoEmpresa()
				+ ", salvo com sucesso!");
		limpar();
		
	}	
	
	public boolean isEditando() {
		return this.cargo.getId() != null;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	}

