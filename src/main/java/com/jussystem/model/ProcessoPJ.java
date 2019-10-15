package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class ProcessoPJ implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String numeroProcesso;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private BigDecimal valorDescontos = BigDecimal.ZERO;
	private BigDecimal valorSalariosMinimos = BigDecimal.ZERO;
	private BigDecimal valorLiquido = BigDecimal.ZERO;
	private Date dataEntrada;

	@Max(value = 35)
	private BigDecimal percentual = BigDecimal.ZERO;

	private BigDecimal valorRecebimentoCliente = BigDecimal.ZERO;
	private BigDecimal valorRecebimentoProcesso = BigDecimal.ZERO;

	private ClientePessoaJuridica clientePessoaJuridica;
	private StatusProcesso statusProcesso;
	private NaturezaProcesso naturezaProcesso;
	private CondicaoPagamento condicaoPagamento;

	private List<ContasReceberPF> contasReceber = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	@Column(nullable = false, length = 25, unique = true)
	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	
	@NotNull
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getValorDescontos() {
		return valorDescontos;
	}

	public void setValorDescontos(BigDecimal valorDescontos) {
		if(valorDescontos == null){
			valorDescontos = BigDecimal.ZERO;
		}
		this.valorDescontos = valorDescontos;
	}
	
	@Column(precision = 10, scale = 2)
	public BigDecimal getValorSalariosMinimos() {
		return valorSalariosMinimos;
	}
	
	public void setValorSalariosMinimos(BigDecimal valorSalariosMinimos) {
		if(valorSalariosMinimos == null){
			valorSalariosMinimos = BigDecimal.ZERO;
		}
		this.valorSalariosMinimos = valorSalariosMinimos;
	}

	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
		
	}

	@NotNull(message = "Percentual é obrigatório!")
	@Column(nullable = false, precision = 5, scale = 2)
	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
		
	}
	

	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorRecebimentoCliente() {
		return valorRecebimentoCliente;
	}

	public void setValorRecebimentoCliente(BigDecimal valorRecebimentoCliente) {
		this.valorRecebimentoCliente = valorRecebimentoCliente;
		
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

    @NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public StatusProcesso getStatusProcesso() {
		return statusProcesso;
	}

	public void setStatusProcesso(StatusProcesso statusProcesso) {
		this.statusProcesso = statusProcesso;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public NaturezaProcesso getNaturezaProcesso() {
		return naturezaProcesso;
	}

	public void setNaturezaProcesso(NaturezaProcesso naturezaProcesso) {
		this.naturezaProcesso = naturezaProcesso;
	}

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ContasReceberPF> getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(List<ContasReceberPF> contasReceber) {
		this.contasReceber = contasReceber;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setValorRecebimentoProcesso(BigDecimal valorRecebimentoProcesso) {
		this.valorRecebimentoProcesso = valorRecebimentoProcesso;
		
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
	
	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorRecebimentoProcesso() {
		return valorRecebimentoProcesso;
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
		ProcessoPJ other = (ProcessoPJ) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient
	public String getPercentualStr(){
			DecimalFormat df = new DecimalFormat("##.##");
			return df.format(percentual);
		
	}
	
	@Transient
	public boolean isValorRecebimentoClienteNegativo() {
		return this.getValorRecebimentoCliente().compareTo(BigDecimal.ZERO) < 0;
	}
	
	@Transient
	public boolean isValorLiquidoNegativo(){
		return this.getValorLiquido().compareTo(BigDecimal.ZERO) < 0;
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	public void recalcularValorLiquido() {
		BigDecimal totalLiquido = BigDecimal.ZERO;
		BigDecimal totalEscritorio = BigDecimal.ZERO;
		BigDecimal totalCliente = BigDecimal.ZERO;
		
		totalLiquido = totalLiquido.add(this.getValorTotal()).subtract(this.getValorDescontos());
		totalEscritorio = totalLiquido.multiply(this.getPercentual()).divide(new BigDecimal("100"));
		totalCliente = totalLiquido.subtract(totalEscritorio);
		
		setValorRecebimentoCliente(totalCliente);
		setValorRecebimentoProcesso(totalEscritorio);
		setValorLiquido(totalLiquido);
		
		
	}
	
	public void recalcularValorLiquidoCivil(){
		BigDecimal totalLiquido = BigDecimal.ZERO;
		BigDecimal totalEscritorio = BigDecimal.ZERO;
		BigDecimal totalCliente = BigDecimal.ZERO;
		
		totalLiquido = totalLiquido.add(this.getValorTotal());
		totalEscritorio = totalLiquido.multiply(this.getPercentual()).divide(new BigDecimal("100")).add(getValorSalariosMinimos());
		totalCliente = totalLiquido.subtract(totalEscritorio);
		
		this.setValorRecebimentoCliente(totalCliente);
		this.setValorRecebimentoProcesso(totalEscritorio);
		this.setValorLiquido(totalLiquido);
		
		
		
	}

	

	
	
}
