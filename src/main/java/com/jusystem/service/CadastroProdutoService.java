package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Produto;
import com.jussystem.repository.Produtos;
import com.jussystem.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porNome(produto.getNome());
		
		if(produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Já existe um produto cadastrado com esta descrição!");
		}
		return produtos.guardar(produto);
	}
}
