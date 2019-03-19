package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;
import com.jussystem.util.jpa.Transactional;



public class CadastroPessoaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	public Pessoas pessoas;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) throws NegocioException{
		return pessoas.guardar(pessoa);
	}
}
