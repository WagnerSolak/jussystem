package com.jussystem.repository.filter;

import java.io.Serializable;

public class PessoaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String documentoReceitaFederal;
	private String nome;
	
	
	
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}
	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
