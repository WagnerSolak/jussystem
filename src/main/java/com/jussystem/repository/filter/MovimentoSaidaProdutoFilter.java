package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.jussystem.model.StatusMovimentoSaidaProduto;

public class MovimentoSaidaProdutoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long numeroDe;
	private Long numeroAte;
	private String nomeProduto;
	private Date dataSaidaDe;
	private Date dataSaidaAte;
	private String nomeUsuario;
	private StatusMovimentoSaidaProduto[] statuses;
	
	
	
	public StatusMovimentoSaidaProduto[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusMovimentoSaidaProduto[] statuses) {
		this.statuses = statuses;
	}

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

	public Long getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Long getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	
}


