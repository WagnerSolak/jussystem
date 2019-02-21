package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Cidade;
import com.jussystem.repository.Cidades;

public class CadastroCidadeService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cidades cidades;
	
	public Cidade salvar(Cidade cidade) {
		
		return cidades.guardar(cidade);
	}
	
	

}
