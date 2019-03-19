package com.jussystem.model;

public enum TipoPessoa {

	FISICA("Física", "CPF", "999.999.999-99"),
	JURIDICA("Jurídica", "CNPJ", "99.999.999/9999-99");
	
	private String descricao;
	private String rotulo;
	private String mascara;
	
	 TipoPessoa(String descricao, String rotulo, String mascara) {
		 this.descricao = descricao;
		 this.rotulo = rotulo;
		 this.mascara = mascara;
	 }
	 
	 public String getDescricao() {
		return descricao;
	}
	 
	 public String getRotulo() {
		return rotulo;
	}
	 
	 public String getMascara() {
		return mascara;
	}
}
