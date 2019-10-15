package com.jussystem.model;

public enum StatusFornecedor {

	ATIVO("Ativo"),
	INATIVO("Inativo");

	private String descricao;
	
	StatusFornecedor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
