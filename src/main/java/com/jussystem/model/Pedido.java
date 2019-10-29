package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dataCriacao;
	private String observacao;
	private Date dataEmissao;
	private Date dataCancelamento;
	private BigDecimal valorFrete = BigDecimal.ZERO;
	private BigDecimal valorDesconto = BigDecimal.ZERO;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	
	private StatusPedido status = StatusPedido.ORCAMENTO;
	private FormaPagamento formaPagamento;
	private Usuario comprador;
	private Fornecedor fornecedor;
	private List<ItemPedido> itens = new ArrayList<>();
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@ManyToOne
	@JoinColumn
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "comprador_id", nullable = false)
	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "fornecedor_id")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	

	/*@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "fornecedor_id")
	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
	}*/

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient
	public BigDecimal getValorSubTotal() {
		return this.getValorTotal().subtract(this.getValorFrete().add(this.getValorDesconto()));
	}

	public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		if (this.getValorFrete() == null){
			this.setValorFrete(BigDecimal.ZERO);
		}
		if(this.getValorDesconto() == null){
			this.setValorDesconto(BigDecimal.ZERO);
		}
		
		total = total.add(this.getValorFrete()).subtract(this.getValorDesconto());

		for (ItemPedido item : this.getItens()) {
			if (item.getProduto() != null && item.getProduto().getId() != null) {
				total = total.add(item.getValorTotal());
			}
		}

		this.setValorTotal(total);

	}

	public void adicionarItemVazio() {
		if(this.isOrcamento()) {
			Produto produto = new Produto();
		
			
			ItemPedido item = new ItemPedido();
			
			item.setProduto(produto);
			item.setPedido(this);
			
			this.getItens().add(0, item);
	}
	}

	@Transient
	public boolean isOrcamento() {
		return StatusPedido.ORCAMENTO.equals(this.getStatus());
	}
	
	@Transient
	public boolean isEmitido() {
		return StatusPedido.EMITIDO.equals(this.getStatus());
	}

	public void removerItemVazio() {
		ItemPedido primeiroItem = this.getItens().get(0);
		
		if(primeiroItem != null && primeiroItem.getProduto().getId() == null) {
			this.getItens().remove(0);
		}
		
	}

	@Transient
	public boolean isValorTotalNegativo() {
		return this.getValorTotal().compareTo(BigDecimal.ZERO) < 0;
	
	}

	@Transient
	public boolean isNaoEnviavelPorEmail() {
		return this.isNovo() || this.isCancelado(); 
	}

	@Transient
	public boolean isNaoEmissivel() {
		return !this.isEmissivel();
	}

	@Transient
	private boolean isEmissivel() {
		return this.isExistente() && this.isOrcamento();
	}
	
	@Transient
	public boolean isNaoCancelavel() {
		return !isCancelavel();
	}

	@Transient
	private boolean isCancelavel() {
		return this.isExistente() && !this.isCancelado();
	}
	
	@Transient
	private boolean isCancelado() {
		return StatusPedido.CANCELADO.equals(this.getStatus());
	}
	
	@Transient
	public boolean isNaoAlteravel() {
		return !this.isAlteravel();
	}
	
	@Transient
	private boolean isAlteravel() {
		return this.isOrcamento();
	}
	
	
	//Implementação Emissão Pedido
/*	public void criarParcela(Integer quantidadeParcela) {
		BigDecimal totalParcelas = valorTotal.subtract(valorEntrada);
		
		if(quantidadeParcela == null) {
			quantidadeParcela = 1;
			this.setQuantidadeParcela(quantidadeParcela);
		}
		contasPagar = new ArrayList<>();
		for(int i = 1; i <= quantidadeParcela; i++) {
			ContasPagar cp = new ContasPagar();
			cp.setNumeroParcela(i+"/"+quantidadeParcela);
			cp.setDataEmissao(new Date());
			cp.setPedido(this);
			cp.setPessoa(this.fornecedor);  //como pegar a pessoa do pedido????????????????????????????
			cp.setValorPago(BigDecimal.ZERO);
			cp.setValorAbatimento(BigDecimal.ZERO);
			cp.setValorMoraMulta(BigDecimal.ZERO);
			cp.setSituacao("Em Aberto");
		
			Calendar vencimento = Calendar.getInstance();
			vencimento.add(Calendar.DAY_OF_MONTH, 30 * i);
			cp.setDataVencimento(vencimento.getTime());
			cp.setValorTotal(totalParcelas.divide(new BigDecimal(quantidadeParcela), BigDecimal.ROUND_HALF_UP));
			cp.setValorRestante(totalParcelas.divide(new BigDecimal(quantidadeParcela), BigDecimal.ROUND_HALF_UP));
		}
	}
	
	public void recalcularParcela() {
		Integer par = quantidadeParcela;
		par = par -1;
	    BigDecimal retotal = BigDecimal.ZERO;
	    BigDecimal ultimaParcela = BigDecimal.ZERO;
	    
	    
	    for(int i = 0; i < quantidadeParcela; i++) {
	    	System.out.println("Teste de recalculo...");
	    	
	    	if(par.equals(i)) {
	    		System.out.println("Ultima parcela");
	    		ultimaParcela = TotalDesc.subtract(retotal);
		    	contasPagar.get(i).setValorTotal(ultimaParcela);
		    	System.out.println("Ultima Parcela " + ultimaParcela);
	    	}else {
	    		retotal = retotal.add(contasPagar.get(i).getValorTotal());
	    		System.out.println(retotal);
	    		System.out.println(i);
	    	}
	    	
	    }
		
	}
*/
}
