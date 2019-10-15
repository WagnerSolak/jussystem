package com.jussystem.repository.filter;

import java.io.Serializable;

public class FormaPagamentoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao == null ? null : descricao.toUpperCase();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	
}
