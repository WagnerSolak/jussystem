package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jussystem.repository.filter.UsuarioFilter;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	private UsuarioFilter filtro;
	private List<Usuario> usuariosFiltrados;
	
	
	public PesquisaUsuarioBean() {
		filtro = new UsuarioFilter();
	}
	
	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
	}
	
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
	
	public UsuarioFilter getFiltro() {
		return filtro;
	}
	
}
