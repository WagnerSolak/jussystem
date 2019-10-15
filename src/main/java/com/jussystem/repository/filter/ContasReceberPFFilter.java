package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.jussystem.model.StatusContasReceber;


public class ContasReceberPFFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String numeroProcesso;
	private Long numeroDe;
	private Long numeroAte;
	private String nomePessoa;
	private Date dataContasReceberDe;
	private Date dataContasReceberAte;
	private Date dataPagamentoDe;
	private Date dataPagamentoAte;
	private Date dataVencimentoDe;
	private Date dataVencimentoAte;
	private StatusContasReceber[] statuses;

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

	public Date getDataContasReceberDe() {
		return dataContasReceberDe;
	}

	public void setDataContasReceberDe(Date dataContasReceberDe) {
		this.dataContasReceberDe = dataContasReceberDe;
	}

	public Date getDataContasReceberAte() {
		return dataContasReceberAte;
	}

	public void setDataContasReceberAte(Date dataContasReceberAte) {
		this.dataContasReceberAte = dataContasReceberAte;
	}

	public StatusContasReceber[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusContasReceber[] statuses) {
		this.statuses = statuses;
	}

	public Date getDataPagamentoDe() {
		return dataPagamentoDe;
	}

	public void setDataPagamentoDe(Date dataPagamentoDe) {
		this.dataPagamentoDe = dataPagamentoDe;
	}

	public Date getDataPagamentoAte() {
		return dataPagamentoAte;
	}

	public void setDataPagamentoAte(Date dataPagamentoAte) {
		this.dataPagamentoAte = dataPagamentoAte;
	}

	public Date getDataVencimentoDe() {
		return dataVencimentoDe;
	}

	public void setDataVencimentoDe(Date dataVencimentoDe) {
		this.dataVencimentoDe = dataVencimentoDe;
	}

	public Date getDataVencimentoAte() {
		return dataVencimentoAte;
	}

	public void setDataVencimentoAte(Date dataVencimentoAte) {
		this.dataVencimentoAte = dataVencimentoAte;
	}
	
	
	
}
