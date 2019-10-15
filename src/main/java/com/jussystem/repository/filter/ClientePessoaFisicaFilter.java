package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;



public class ClientePessoaFisicaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroDe;
	private Long numeroAte;
	private String cpf;
	private String nome;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	
	
	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}
	
	public Long getNumeroDe() {
		return numeroDe;
	}
	
	public Long getNumeroAte() {
		return numeroAte;
	}
	
	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}
	
	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}
	
	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}
	
	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}
	
	
	
}
