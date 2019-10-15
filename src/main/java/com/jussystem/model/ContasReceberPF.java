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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class ContasReceberPF implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numeroParcela;
	private Date dataEmissao;
	private Date dataPagamento;
	private Date dataVencimento;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private BigDecimal valorPago = BigDecimal.ZERO;
	private BigDecimal valorRestante = BigDecimal.ZERO;
	private BigDecimal valorAbatimento = BigDecimal.ZERO;
	private BigDecimal valorMoraMulta = BigDecimal.ZERO;
	
	private CondicaoPagamento condicaoPagamento;
	private FormaPagamento formaPagamento;
	private StatusContasReceber status;
	
	private ClientePessoaFisica clientePessoaFisica;
	private ProcessoPF processo;
	
	//testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	private CondicaoDePagamento CondicaoDePagamento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 3)
	public String getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(String numeroParcela) {
		this.numeroParcela = numeroParcela;
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
	
	public void setValorAbatimento(BigDecimal valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorAbatimento() {
		return valorAbatimento;
	}
	
	public void setValorMoraMulta(BigDecimal valorMoraMulta) {
		this.valorMoraMulta = valorMoraMulta;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorMoraMulta() {
		return valorMoraMulta;
	}

	
	
	@ManyToOne
	@JoinColumn(name = "processo_id")
	public ProcessoPF getProcesso() {
		return processo;
	}
	public void setProcesso(ProcessoPF processo) {
		this.processo = processo;
	}
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "clientepessoafisica_id")
	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
	}
	
	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}
	
	
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	@ManyToOne
	@JoinColumn(name = "formaPagamento_id")
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setStatus(StatusContasReceber status) {
		this.status = status;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}
	
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
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
		ContasReceberPF other = (ContasReceberPF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
	
	//testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	public void setCondicaoDePagamento(CondicaoDePagamento condicaoDePagamento) {
		CondicaoDePagamento = condicaoDePagamento;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "condicaoDePagamento_id")
	public CondicaoDePagamento getCondicaoDePagamento() {
		return CondicaoDePagamento;
	}
	
}
