package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.Produto;
import com.jussystem.repository.MotivoSaidaProdutos;
import com.jussystem.repository.Produtos;
import com.jussystem.security.Seguranca;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.MovimentoSaidaProdutoService;

@Named
@ViewScoped
public class MovimentoSaidaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MovimentoSaidaProduto movimentoSaidaProduto;


	@Inject
	private Produtos produtos;
	
	private Produto produto;
	
	@Inject
	private Seguranca seguranca;
	
	@Inject
	private MovimentoSaidaProdutoService movimentoSaidaProdutoService;
	
	@Inject
	private MotivoSaidaProdutos motivoSaidaProdutos;
	
	private List<MotivoSaidaProduto> motivosSaidaProduto;
	
	
	public MovimentoSaidaProdutoBean() {
		limpar();

	}
	
	public void buscar(){
		try {
			Produto resultado = produtos.porId(produto.getId());
			
			if(resultado == null){
				FacesUtil.addInfoMessage("Não existe produto cadastrado no sistema com este código!");
			}else{
				produto = resultado;
			}
		} catch (RuntimeException e) {
			e.getMessage();
			FacesUtil.addErrorMessage("Ocorreu um erro ao tentar buscar o produto!");
		}
	}
	
	public void inicializar() {
		if (movimentoSaidaProduto == null) {
			limpar();
			
		}
		motivosSaidaProduto = motivoSaidaProdutos.buscarMotivos();
		
	}
	
	public void salvarMovimentoSaida(){
		
		
		movimentoSaidaProduto.setDataSaida(new Date());
		movimentoSaidaProduto.setProduto(produto);
		//movimentoSaidaProduto.setUsuario(seguranca.getUsuarioLogado().getUsuario());
		
		movimentoSaidaProduto = movimentoSaidaProdutoService.salvar(movimentoSaidaProduto);

		FacesUtil.addInfoMessage("Movimento do produto: " + movimentoSaidaProduto.getProduto().getNome()
				+ ", salvo com sucesso!");
		limpar();
		
	}
	
	public void limpar(){
		movimentoSaidaProduto = new MovimentoSaidaProduto();
		produto = new Produto();
	}
	
	public Date getMostrarDataAtual(){
		return new Date();
	}

	public List<MotivoSaidaProduto> getMotivosSaidaProduto() {
		return motivosSaidaProduto;
	}
	
	public void setMovimentoSaidaProduto(
			MovimentoSaidaProduto movimentoSaidaProduto) {
		this.movimentoSaidaProduto = movimentoSaidaProduto;
	}
	
	public MovimentoSaidaProduto getMovimentoSaidaProduto() {
		return movimentoSaidaProduto;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}
}
