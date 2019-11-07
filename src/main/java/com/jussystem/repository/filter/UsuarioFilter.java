package com.jussystem.repository.filter;

import java.io.Serializable;

import com.jussystem.model.StatusUsuario;


public class UsuarioFilter implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private String nome;
	private String email;
	private StatusUsuario[] statuses;
	
	public void setNome(String nome) {
		this.nome = nome ==null ? null :nome.toUpperCase();
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusUsuario[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusUsuario[] statuses) {
		this.statuses = statuses;
	}

	public Long getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Long getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}

	
	
	
}
