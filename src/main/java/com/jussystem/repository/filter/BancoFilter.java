package com.jussystem.repository.filter;

import java.io.Serializable;

public class BancoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String compe;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome == null ? null : nome.toUpperCase();
	}
	public String getCompe() {
		return compe;
	}
	public void setCompe(String compe) {
		this.compe = compe;
	}
	
	
}
