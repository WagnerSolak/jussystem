package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.jussystem.model.MotivoSaidaProduto;

import com.jussystem.repository.MotivoSaidaProdutos;
import com.jussystem.util.jpa.Transactional;

public class CadastroMotivoSaidaProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotivoSaidaProdutos motivoSaidaProdutos;
	
	@Transactional
	public MotivoSaidaProduto salvar(MotivoSaidaProduto motivoSaidaProduto) {
		MotivoSaidaProduto motivoSaidaProdutoExistente = motivoSaidaProdutos.porNomeDoMotivo(motivoSaidaProduto.getMotivoSaida());
		
		if(motivoSaidaProdutoExistente != null && !motivoSaidaProdutoExistente.equals(motivoSaidaProduto)) {
			throw new NegocioException("Já existe um motivo com a descrição informada!");
		}
		return motivoSaidaProdutos.guardar(motivoSaidaProduto);
	}
}
