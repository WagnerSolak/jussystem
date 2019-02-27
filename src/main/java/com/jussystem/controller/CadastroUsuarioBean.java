package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jusystem.service.CadastroUsuarioService;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	@Inject
	private Usuarios usuarios;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	
	public CadastroUsuarioBean() {
		usuario = new Usuario();
	}
	
	public void salvar() {
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
