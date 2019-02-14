package com.jussystem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.jussystem.model.Estado;


public class Estados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	
	public Estado guardar(Estado estado) {
		return  manager.merge(estado);
		
	}

	public Estado porNome(String nome) {
		try {
		return manager.createQuery("from Estado where upper(nome) = :nome", Estado.class)
				.setParameter("nome", nome.toUpperCase())
				.getSingleResult();
		
		}catch (NoResultException e) {
			return null;
		}
	}
}
