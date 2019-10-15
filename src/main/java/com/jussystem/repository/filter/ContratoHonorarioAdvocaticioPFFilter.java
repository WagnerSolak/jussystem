package com.jussystem.repository.filter;

import java.io.Serializable;
import java.util.Date;

public class ContratoHonorarioAdvocaticioPFFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroDe;
	private Long numeroAte;
	private String nomePessoa;
	private Date dataDocumentoDe;
	private Date dataDocumentoAte;

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

	public Date getDataDocumentoDe() {
		return dataDocumentoDe;
	}

	public void setDataDocumentoDe(Date dataDocumentoDe) {
		this.dataDocumentoDe = dataDocumentoDe;
	}

	public Date getDataDocumentoAte() {
		return dataDocumentoAte;
	}

	public void setDataDocumentoAte(Date dataDocumentoAte) {
		this.dataDocumentoAte = dataDocumentoAte;
	}

}
