package com.jussystem.repository;

import java.io.Serializable;


import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.DeclaracaoJusticaGratuita;


public class DeclaracaoJusticaGratuitas implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public DeclaracaoJusticaGratuita guardar(DeclaracaoJusticaGratuita declaracaoJusticaGratuita) {
		return manager.merge(declaracaoJusticaGratuita);
	}
	
	 
}
