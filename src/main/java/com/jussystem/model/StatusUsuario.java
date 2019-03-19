package com.jussystem.model;

public enum StatusUsuario {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	StatusUsuario(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
