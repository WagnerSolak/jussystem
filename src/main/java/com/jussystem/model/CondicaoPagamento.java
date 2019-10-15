package com.jussystem.model;

public enum CondicaoPagamento {
	
	AVISTA("Á Vista"),
	APRAZO("Á Prazo");
	
	
	private String descricao;

	CondicaoPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
