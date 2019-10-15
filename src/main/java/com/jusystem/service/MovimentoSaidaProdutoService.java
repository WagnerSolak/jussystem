package com.jusystem.service;

import java.io.Serializable;


import javax.inject.Inject;

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.util.jpa.Transactional;

public class MovimentoSaidaProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	

	
	@Inject
	private MovimentoSaidaProdutos movimentos;
	
	@Transactional
	public MovimentoSaidaProduto salvar(MovimentoSaidaProduto movimento) {

		return movimentos.guardar(movimento);
	}
}
