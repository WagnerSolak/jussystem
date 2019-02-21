package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.FormaPagamento;
import com.jussystem.model.Pedido;
import com.jussystem.model.Pessoa;
import com.jussystem.model.Usuario;
import com.jussystem.repository.Pessoas;
import com.jussystem.repository.Usuarios;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroPedidoService;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private Pessoas pessoas;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	private Pedido pedido;
	private List<Usuario> compradores;

	public CadastroPedidoBean() {
		limpar();

	}

	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			this.compradores = this.usuarios.compradores();
		}
	}
	
	public void salvar() {
		this.pedido =  this.cadastroPedidoService.salvar(pedido);
		//limpar(); ver com Roni, pq pode emitir, mandar por email, etc
		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}

	public void limpar() {
		pedido = new Pedido();
		
	}

	public List<Pessoa> completarFornecedor(String nome){
		return this.pessoas.porNome(nome);
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Usuario> getCompradores() {
		return compradores;
	}
	
	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}
	
	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

}
