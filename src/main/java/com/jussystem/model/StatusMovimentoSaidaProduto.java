package com.jussystem.model;

public enum StatusMovimentoSaidaProduto {
	
	ATIVO("Ativo"),
	CANCELADO("Cancelado");
	
	
	private String descricao;
	
	StatusMovimentoSaidaProduto(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
