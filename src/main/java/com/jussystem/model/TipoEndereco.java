package com.jussystem.model;

public enum TipoEndereco {
	
	
	RESIDENCIAL("Residencial"),
	COMERCIAL("Comercial"),
	CORRESPONDECIA("Correspondência"),
	COBRANCA("Cobrança");
	
	private String descricao;
	
	TipoEndereco(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
