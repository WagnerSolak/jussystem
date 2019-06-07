package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.InativaPessoa;
import com.jussystem.repository.InativaPessoas;
import com.jussystem.util.jpa.Transactional;

public class MovimentoInativaPessoaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InativaPessoas inativaPessoas;
	
	@Transactional
	public InativaPessoa salvar(InativaPessoa inativaPessoa) throws NegocioException{
		return inativaPessoas.guardar(inativaPessoa);
	}
}
