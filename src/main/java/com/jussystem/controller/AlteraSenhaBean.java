package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jussystem.model.Usuario;
import com.jussystem.security.UsuarioLogado;
import com.jussystem.security.UsuarioSistema;

@Named
@ViewScoped
public class AlteraSenhaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	
	private String senhaAtual;
	private String novaSenha;
	private String confirmaSenha;
	
	
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	public String getNovaSenha() {
		return novaSenha;
	}
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public void alteraSenhaUsuario(){
		
		
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
