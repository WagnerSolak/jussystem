package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Cidade;
import com.jussystem.repository.Cidades;
import com.jussystem.util.jpa.Transactional;

public class CadastroCidadeService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cidades cidades;
	
	@Transactional
	public Cidade salvar(Cidade cidade) {
		Cidade cidadeExistente = cidades.porNome(cidade.getNome());
		
		if(cidadeExistente != null && !cidadeExistente.equals(cidade) ) {
			throw new NegocioException("Já existe um produto com a descrição informada!");
		}
		return cidades.guardar(cidade);
	}
	
	

}
