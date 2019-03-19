package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jussystem.util.jsf.FacesUtil;
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

	private ArrayList statusUsuario;
	
	
	public CadastroUsuarioBean() {
		limpar();
	}
	
	public void salvar() {
		
		usuario = cadastroUsuarioService.salvar(usuario);
		limpar();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
		
	}
	
	private void limpar() {
		usuario = new Usuario();
		statusUsuario = new ArrayList<>();
	}
	
	/*public StatusTipoUsuario[] getStatusTipoUsuario() {     apaguar, vai mudar para entidade grupo e nao enum
		return StatusTipoUsuario.values();
	}*/
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
