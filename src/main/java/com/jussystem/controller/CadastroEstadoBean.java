package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jussystem.model.Estado;

@Named
@ViewScoped
public class CadastroEstadoBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Estado estado;
	
	public CadastroEstadoBean() {
		estado = new Estado();
	}
	
	public Estado getEstado() {
		return estado;
	}
	
}
