package com.jusystem.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;


import com.jussystem.model.Pedido;
import com.jussystem.model.StatusPedido;
import com.jussystem.repository.Pedidos;
import com.jussystem.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		
		if(pedido.isNaoEmissivel()) {
			throw new NegocioException("Pedido não pode ser emitido com status " 
						+ pedido.getStatus().getDescricao() + ".");
		}
		
		this.estoqueService.adicionarItensEstoque(pedido);
		
		pedido.setStatus(StatusPedido.EMITIDO);
		pedido.setDataEmissao(new Date());
		
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}
	
	
}
