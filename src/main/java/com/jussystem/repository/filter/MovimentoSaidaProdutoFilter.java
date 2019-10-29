package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

public class MovimentoSaidaProdutoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataSaidaDe;
	private Date dataSaidaAte;
	private String nomeUsuario;
	
	
	
	public Date getDataSaidaDe() {
		return dataSaidaDe;
	}

	public void setDataSaidaDe(Date dataSaidaDe) {
		this.dataSaidaDe = dataSaidaDe;
	}

	public Date getDataSaidaAte() {
		return dataSaidaAte;
	}

	public void setDataSaidaAte(Date dataSaidaAte) {
		this.dataSaidaAte = dataSaidaAte;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}


