package com.jussystem.model;

public enum StatusContasReceber {
	
	ABERTO("Em aberto"),
	PAGO("Pago"),
	PAGOPARCIAL("Pago parcial");
	
	private String descricao;
	
	StatusContasReceber(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
