package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.Produto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.repository.Produtos;
import com.jussystem.util.jpa.Transactional;
import com.jussystem.util.jsf.FacesUtil;

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
		
		if(qtde >= 0){
			
			produto.setEstoque(new Short(qtde + ""));
			produto = produtos.guardar(produto);
		}else{
			FacesUtil.addErrorMessage("A quantidade de saída não pode ser maior que o estoque!");
		}
		
		
		return movimentoSaidaProdutos.guardar(movimentoSaidaProduto); 
				
	}
	
	
}
