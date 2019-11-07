package com.jussystem.repository.filter;

import java.io.Serializable;

public class MotivoSaidaProdutoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private String nome;
	
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
	
	
}
