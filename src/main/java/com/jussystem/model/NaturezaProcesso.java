package com.jussystem.model;

public enum NaturezaProcesso {

	
	TRABALHO("Trabalho"),
	CIVIL("Cívil");

	private String descricao;

	NaturezaProcesso(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
