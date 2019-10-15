package com.jussystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProcuracaoAdJudiciaPJ implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataDocumento;
	
	private ClientePessoaJuridica clientePessoaJuridica;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataDocumento() {
		return dataDocumento;
	}
	
	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	
	public void setClientePessoaJuridica(
			ClientePessoaJuridica clientePessoaJuridica) {
		this.clientePessoaJuridica = clientePessoaJuridica;
	}
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "clientePessoaJuridica_id")
	public ClientePessoaJuridica getClientePessoaJuridica() {
		return clientePessoaJuridica;
	}
}
