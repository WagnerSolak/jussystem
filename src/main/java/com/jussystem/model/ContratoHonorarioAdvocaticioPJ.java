package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.Max;

@Entity
public class ContratoHonorarioAdvocaticioPJ implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dataDocumento;
	private BigDecimal salariosMinimo;

	@Max(value = 35)
	private BigDecimal percentual;

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

	@Column(precision = 10, scale = 1)
	public BigDecimal getSalariosMinimo() {
			return salariosMinimo;
		
	}

	public void setSalariosMinimo(BigDecimal salariosMinimo) {
		this.salariosMinimo = salariosMinimo;
	}

	@Transient
	public String getSalariosMinimoStr() {
		if (salariosMinimo == null) {
			return "0";
		} else {
			DecimalFormat df = new DecimalFormat("##.##");
			return df.format(salariosMinimo);
		}

	}

	@Column(nullable = false, precision = 5, scale = 2)
	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	@Transient
	public String getPercentualStr() {
		DecimalFormat df = new DecimalFormat("##.##");
		return df.format(percentual);
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
		ContratoHonorarioAdvocaticioPJ other = (ContratoHonorarioAdvocaticioPJ) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
