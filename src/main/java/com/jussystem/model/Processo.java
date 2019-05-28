package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
@Entity
public class Processo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String numeroProcesso;
	private BigDecimal valorTotal;
	private BigDecimal valorDescontos;
	private BigDecimal valorLiquido;
	
	@Max(value = 35)
	private BigDecimal percentual;
	
	private BigDecimal valorRecebimentoCliente;
	
	private Pessoa pessoa;
	private StatusProcesso statusProcesso;
	private NaturezaProcesso naturezaProcesso;
	
	private List<ContasReceber> contasReceber = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 25)
	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	@Column(nullable = false,precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Column(nullable = false,precision = 10, scale = 2)
	public BigDecimal getValorDescontos() {
		return valorDescontos;
	}

	public void setValorDescontos(BigDecimal valorDescontos) {
		this.valorDescontos = valorDescontos;
	}

	@Column(nullable = false,precision = 10, scale = 2)
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Column(nullable = false,precision = 5, scale = 2)
	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	@Column(nullable = false,precision = 10, scale = 2)
	public BigDecimal getValorRecebimentoCliente() {
		return valorRecebimentoCliente;
	}

	public void setValorRecebimentoCliente(BigDecimal valorRecebimentoCliente) {
		this.valorRecebimentoCliente = valorRecebimentoCliente;
	}

	@ManyToOne
	@JoinColumn(nullable = false, name = "pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public StatusProcesso getStatusProcesso() {
		return statusProcesso;
	}

	public void setStatusProcesso(StatusProcesso statusProcesso) {
		this.statusProcesso = statusProcesso;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public NaturezaProcesso getNaturezaProcesso() {
		return naturezaProcesso;
	}

	public void setNaturezaProcesso(NaturezaProcesso naturezaProcesso) {
		this.naturezaProcesso = naturezaProcesso;
	}

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ContasReceber> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<ContasReceber> contasReceber) {
		this.contasReceber = contasReceber;
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
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
