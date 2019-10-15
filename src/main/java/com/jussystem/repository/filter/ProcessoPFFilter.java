package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.jussystem.model.StatusProcesso;

public class ProcessoPFFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String numeroProcesso;
	private Long numeroDe;
	private Long numeroAte;
	private String nomePessoa;
	private Date dataProcessoDe;
	private Date dataProcessoAte;
	private StatusProcesso[] statuses;

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
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

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Date getDataProcessoDe() {
		return dataProcessoDe;
	}

	public void setDataProcessoDe(Date dataProcessoDe) {
		this.dataProcessoDe = dataProcessoDe;
	}

	public Date getDataProcessoAte() {
		return dataProcessoAte;
	}

	public void setDataProcessoAte(Date dataProcessoAte) {
		this.dataProcessoAte = dataProcessoAte;
	}
	
	public void setStatuses(StatusProcesso[] statuses) {
		this.statuses = statuses;
	}
	
	public StatusProcesso[] getStatuses() {
		return statuses;
	}

}
