package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ItemPedido;
import com.jussystem.model.Pedido;
import com.jussystem.repository.Pedidos;
import com.jussystem.util.jpa.Transactional;

public class EstoqueService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public void adicionarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for(ItemPedido item : pedido.getItens()) {
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}
	}

	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for(ItemPedido item : pedido.getItens()) {
			item.getProduto().subtrairEstoque(item.getQuantidade());
		}
		
	}
}
