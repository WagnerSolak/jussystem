package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Pedido;
import com.jussystem.model.StatusPedido;
import com.jussystem.repository.Pedidos;
import com.jussystem.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	private PedidoFilter filtro;
	
	private List<Pedido> pedidosFiltrados;
	
	public PesquisaPedidoBean() {
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}
	
	public void pesquisar() {
		pedidosFiltrados = pedidos.filtrados(filtro);
	}
	
	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}
	
	public StatusPedido[] getStatuses() {
		return StatusPedido.values();
	}
	
	public PedidoFilter getFiltro() {
		return filtro;
	}
}
