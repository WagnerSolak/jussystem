package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class ProcessoPF implements Serializable {

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

	
	private ClientePessoaFisica clientePessoaFisica;
	private StatusProcesso statusProcesso;
	private NaturezaProcesso naturezaProcesso;
	private CondicaoPagamento condicaoPagamento;

	private List<ContasReceberPF> contasReceberPF = new ArrayList<>();

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
	@Column(nullable = false, precision = 10, scale = 2)
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
	
	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}
	
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "clientePessoaFisica_id")
	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
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
	@Column(nullable = false, length = 10)
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}
	
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
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

	@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<ContasReceberPF> getContasReceberPF() {
		return contasReceberPF;
	}
	
	public void setContasReceberPF(List<ContasReceberPF> contasReceberPF) {
		this.contasReceberPF = contasReceberPF;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setValorRecebimentoProcesso(BigDecimal valorRecebimentoProcesso) {
		this.valorRecebimentoProcesso = valorRecebimentoProcesso;
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
		ProcessoPF other = (ProcessoPF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void recalcularValorLiquido() {
		BigDecimal totalLiquido = BigDecimal.ZERO;
		BigDecimal totalEscritorio = BigDecimal.ZERO;
		BigDecimal totalCliente = BigDecimal.ZERO;
		
		
		
		totalLiquido = totalLiquido.add(this.getValorTotal()).subtract(this.getValorDescontos());
		totalEscritorio = totalLiquido.multiply(this.getPercentual()).divide(new BigDecimal("100"));
		totalCliente = totalLiquido.subtract(totalEscritorio);

		this.setValorRecebimentoCliente(totalCliente);
		this.setValorRecebimentoProcesso(totalEscritorio);
		this.setValorLiquido(totalLiquido);

	}
	
	public void recalcularValorLiquidoCivil(){
		BigDecimal totalLiquido = BigDecimal.ZERO;
		BigDecimal totalEscritorio = BigDecimal.ZERO;
		BigDecimal totalCliente = BigDecimal.ZERO;
		
		totalLiquido = totalLiquido.add(this.getValorTotal());
		totalEscritorio = totalLiquido.multiply(this.getPercentual()).divide(new BigDecimal("100")).add(this.getValorSalariosMinimos());// +salario
		totalCliente = totalLiquido.subtract(totalEscritorio);
		
		this.setValorRecebimentoCliente(totalCliente);
		this.setValorRecebimentoProcesso(totalEscritorio);
		this.setValorLiquido(totalLiquido);
		
		
		
	}
	
	private Integer qtdParcela;
	
	@Transient
	public Integer getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(Integer qtdParcela) {
        this.qtdParcela = qtdParcela;
    }
	
	
	public void gerarParcela(Integer qtdParcela){
		if(!this.condicaoPagamento.getDescricao().equals(CondicaoPagamento.AVISTA)){
			if(qtdParcela == null){
				qtdParcela = 1;
				this.setQtdParcela(qtdParcela);
			}
			contasReceberPF = new ArrayList<>();
			for(int i = 1; i <= qtdParcela; i++){
				
				
				ContasReceberPF cr = new ContasReceberPF();
				cr.setProcesso(this);
				cr.setClientePessoaFisica(getClientePessoaFisica());
				cr.setNumeroParcela(i+"/"+qtdParcela);
				cr.setDataEmissao(new Date());
				cr.setValorMoraMulta(BigDecimal.ZERO);
				cr.setValorAbatimento(BigDecimal.ZERO);
				cr.setValorPago(BigDecimal.ZERO);
				cr.setStatus(StatusContasReceber.ABERTO);
				cr.setCondicaoPagamento(getCondicaoPagamento());
				Calendar vencimento = Calendar.getInstance();
				vencimento.add(Calendar.DAY_OF_MONTH, 30 * i);
				cr.setDataVencimento(vencimento.getTime());
				cr.setValorTotal(valorRecebimentoProcesso.divide(new BigDecimal(qtdParcela), BigDecimal.ROUND_HALF_UP));
				cr.setValorRestante(valorRecebimentoProcesso.divide(new BigDecimal(qtdParcela), BigDecimal.ROUND_HALF_UP));
				contasReceberPF.add(cr);
				
			}
		}
	}
	
	public void recalcularParcela(){
		Integer par = qtdParcela;
		par = par - 1;
		BigDecimal retotal = BigDecimal.ZERO;
		BigDecimal ultimaParcela = BigDecimal.ZERO;
		
		for(int i = 0; i < qtdParcela; i++){
			System.out.println("Teste Recalculando a parcela!");
			
			if(par.equals(i)){
				contasReceberPF.get(i).setValorTotal(ultimaParcela);
				System.out.println("Teste Ultima parcela"+ ultimaParcela);
				
			}else{
				retotal = retotal.add(contasReceberPF.get(i).getValorTotal());
				System.out.println(retotal);
				System.out.println(i);
			}
		}
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
	
	
	
	@Transient
	public boolean isComParcelamento(){
		return CondicaoPagamento.APRAZO.equals(this.getCondicaoPagamento());
	}


}
