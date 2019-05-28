package com.jussystem.model;

public enum NaturezaProcesso {

	CIVIL("Civil"),
	TRABALHO("Trabalho");

	private String descricao;

	NaturezaProcesso(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
