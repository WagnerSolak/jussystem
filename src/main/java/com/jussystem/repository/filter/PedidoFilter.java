package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.jussystem.model.StatusPedido;


public class PedidoFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long numeroDe;
	private Long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String nomeVendedor;
	private String nomeFornecedor;
	private StatusPedido[] statuses;
	
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
	
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	
	public StatusPedido[] getStatuses() {
		return statuses;
	}
	
	public void setStatuses(StatusPedido[] statuses) {
		this.statuses = statuses;
	}
	
	
}
