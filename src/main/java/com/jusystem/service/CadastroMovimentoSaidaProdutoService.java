package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.Produto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.repository.Produtos;
import com.jussystem.util.jpa.Transactional;


public class CadastroMovimentoSaidaProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	@Inject
	private MovimentoSaidaProdutos movimentoSaidaProdutos;
	
	@Transactional
	public MovimentoSaidaProduto salvar(MovimentoSaidaProduto movimentoSaidaProduto) {
		
		Produto produto = movimentoSaidaProduto.getProduto();
		int qtde =  produto.getEstoque() - movimentoSaidaProduto.getQuantidadeNova();
		
		if(qtde < 0){
			throw new NegocioException("A quantidade de saída não pode ser maior que o estoque!");
		}
		
		produto = movimentoSaidaProduto.getProduto();
		produto.setEstoque((short) (produto.getEstoque()- movimentoSaidaProduto.getQuantidadeNova()));
		
		produtos.guardar(produto);
	
		
		return movimentoSaidaProdutos.guardar(movimentoSaidaProduto); 
				
	}

	@Transactional
	public void recalcularNovoEstoque(MovimentoSaidaProduto movimentoSaidaProduto) {
	
		salvar(movimentoSaidaProduto);
		
	}

	@Transactional
	public void recalcularNovoEstoqueCancelado(MovimentoSaidaProduto movimentoSaidaProdutoSelecionado) {
		cancelar(movimentoSaidaProdutoSelecionado);
		
	}

	@Transactional
	private MovimentoSaidaProduto cancelar(MovimentoSaidaProduto movimentoSaidaProdutoSelecionado) {
		Produto produto = movimentoSaidaProdutoSelecionado.getProduto();
		produto = movimentoSaidaProdutoSelecionado.getProduto();
		
		produto.setEstoque((short) (movimentoSaidaProdutoSelecionado.getProduto().getEstoque() + movimentoSaidaProdutoSelecionado.getQuantidadeNova()));
		
	
		produtos.guardar(produto);
		
		return movimentoSaidaProdutos.guardar(movimentoSaidaProdutoSelecionado);
		
	}
	
	
}
