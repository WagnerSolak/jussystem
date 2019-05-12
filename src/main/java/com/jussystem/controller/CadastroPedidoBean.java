package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.FormaPagamento;
import com.jussystem.model.ItemPedido;
import com.jussystem.model.Pedido;
import com.jussystem.model.Pessoa;
import com.jussystem.model.Produto;
import com.jussystem.model.Usuario;
import com.jussystem.repository.FormaPagamentos;
import com.jussystem.repository.Pessoas;
import com.jussystem.repository.Produtos;
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
	private FormaPagamentos formaPagamentos;

	@Inject
	private Pessoas pessoas;

	@Inject
	private CadastroPedidoService cadastroPedidoService;

	@Inject
	private Produtos produtos;

	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private List<Usuario> compradores;
	private List<FormaPagamento>formasPagamento;
	
	private Produto produtoLinhaEditavel;
	private Long id;

	public CadastroPedidoBean() {
		limpar();

	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			this.compradores = this.usuarios.compradores();
			this.formasPagamento = this.formaPagamentos.formaPagamentos();
			
			
			this.pedido.adicionarItemVazio();

			this.recalcularPedido();
		}
	}

	public void salvar() {
		this.pedido.removerItemVazio();

		try {
			this.pedido = this.cadastroPedidoService.salvar(pedido);

			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
		} finally {
			this.pedido.adicionarItemVazio();
		}
	}

	private void limpar() {
		pedido = new Pedido();

	}

	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}
	
	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}

	public void carregarProdutoPorId() {

		if (this.id != null || !this.id.equals("")) {
			this.produtoLinhaEditavel = this.produtos.porId(this.id);
			this.carregarProdutoLinhaEditavel();
		}
	}

	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addInfoMessage("Já existe um item com o nome informado!");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				;
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.id = null;

				this.pedido.recalcularValorTotal();
			}
		}
	}

	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;

		for (ItemPedido item : this.getPedido().getItens()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}

		}
		return existeItem;
	}

	public List<Produto> completarProduto(String nome) {
		return this.produtos.porNomeLista(nome);
	}

	public List<Pessoa> completarFornecedor(String nome) {
		return this.pessoas.porNome(nome);
	}

	public void atualizarQuantidade(ItemPedido item, int linha) {
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);

			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		this.pedido.recalcularValorTotal();
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
	
	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

/*	public FormaPagamento[] getFormasPagamento() { será oimplementado no emissaoPedidoBean
		return FormaPagamento.values();
	}*/

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
