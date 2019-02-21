package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jussystem.model.Cidade;


public class Cidades implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Cidade> buscarCidades(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	public Cidade guardar(Cidade cidade) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		cidade = manager.merge(cidade);
		
		trx.commit();
		return cidade;
	}
}
