package com.jussystem.model;



public enum EstadoCivilCliente {
		
	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	SEPARADO("Separado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	
	private String descricao;
	
	EstadoCivilCliente(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
	
}
