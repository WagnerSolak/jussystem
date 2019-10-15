package com.jussystem.repository.filter;

import java.io.Serializable;

import com.jussystem.model.UfCliente;

public class CidadeFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private UfCliente ufs[];
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUfs(UfCliente[] ufs) {
		this.ufs = ufs;
	}
	
	public UfCliente[] getUfs() {
		return ufs;
	}
}
