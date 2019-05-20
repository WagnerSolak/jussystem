package com.jussystem.model;

public enum EstadoCivilPessoa {
		
	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	SEPARADO("Separado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	
	private String descricao;
	
	EstadoCivilPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
