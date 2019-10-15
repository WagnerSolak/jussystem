package com.jussystem.model;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;






import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class DeclaracaoJusticaGratuitaPF implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataDocumento;
	
	private ClientePessoaFisica clientePessoaFisica;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataDocumento() {
		return dataDocumento;
	}
	
	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	
	@ManyToOne
	@JoinColumn(nullable = false, name = "clientePessoaFisica_id")
	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
	}
	
	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeclaracaoJusticaGratuitaPF other = (DeclaracaoJusticaGratuitaPF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
