package com.jussystem.model;

public enum StatusPessoa { //apagar quando quiser
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	StatusPessoa(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
