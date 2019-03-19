package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ContasPagar implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String situacao;
	private String numeroParcela;
	
	private Date dataEmissao;
	private Date dataVencimento;
	private Date dataPagamento;
	
	private Pedido pedido;
	private Pessoa pessoa;
	
	private BigDecimal valorTotal;
	private BigDecimal valorPago;

}
