package com.jussystem.repository.filter;

import java.io.Serializable;

import com.jussystem.model.UfCliente;

public class CidadeFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private String nome;
	private UfCliente ufs[];
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
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

	public void setUfs(UfCliente[] ufs) {
		this.ufs = ufs;
	}
	
	public UfCliente[] getUfs() {
		return ufs;
	}
}
