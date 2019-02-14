package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;


public class CadastroEstadoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estados estados;
	
	public Estado salvar(Estado estado) {
		Estado estadoExistente = estados.porNome(estado.getNome());
		return estados.guardar(estado);
	}
}
