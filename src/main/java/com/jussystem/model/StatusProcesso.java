package com.jussystem.model;

public enum StatusProcesso {
	
	ANDAMENTO("Andamento"),
	ENCERRADO("Encerrado");
	
	private String descricao;
	
	StatusProcesso(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
