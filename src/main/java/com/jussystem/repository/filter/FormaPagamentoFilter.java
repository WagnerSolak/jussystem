package com.jussystem.repository.filter;

import java.io.Serializable;

public class FormaPagamentoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao == null ? null : descricao.toUpperCase();
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
