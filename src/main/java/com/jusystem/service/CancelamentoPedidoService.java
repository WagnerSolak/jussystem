package com.jusystem.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.jussystem.model.Pedido;
import com.jussystem.model.StatusPedido;
import com.jussystem.repository.Pedidos;
import com.jussystem.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject 
	private EstoqueService estoqueService;
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		if(pedido.isNaoCancelavel()) {
			throw new NegocioException("Pedido não pode ser cancelado no status "
						+ pedido.getStatus().getDescricao() + ".");
		}
		
		if(pedido.isEmitido()) {
			this.estoqueService.baixarItensEstoque(pedido);
			
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		pedido.setDataCancelamento(new Date());
		
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}
}
