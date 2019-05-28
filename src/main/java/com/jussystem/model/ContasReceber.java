package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class ContasReceber implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer numeroParcela;
	private Integer numeroDocumento;
	private Date dataEmissao;
	private Date dataPagamento;
	private Date dataVencimento;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private BigDecimal valorPago = BigDecimal.ZERO;
	private BigDecimal valorRestante = BigDecimal.ZERO;
	
	private FormaPagamento formaPagamento;
	private Processo processo;
	private Pessoa pessoa;
	private StatusContasReceber status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 3)
	public Integer getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	
	@Column(nullable = false, length = 20)
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorRestante() {
		return valorRestante;
	}
	public void setValorRestante(BigDecimal valorRestante) {
		this.valorRestante = valorRestante;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "processo_id", nullable = false)
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	@ManyToOne
	@JoinColumn(name = "formaPagamento_id", nullable = false)
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setStatus(StatusContasReceber status) {
		this.status = status;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	public StatusContasReceber getStatus() {
		return status;
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
		ContasReceber other = (ContasReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
