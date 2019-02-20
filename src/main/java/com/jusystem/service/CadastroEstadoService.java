package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;
import com.jussystem.util.jpa.Transactional;



public class CadastroEstadoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estados estados;
	
	@Transactional
	public Estado salvar(Estado estado) {
/*	Estado estadoExistente = estados.porNome(estado.getNome());
		if(estadoExistente !=null) {
			throw new NegocioException("Já existe um estado com este nome cadastrado!");
		}*/
		return estados.guardar(estado);
	}
}
