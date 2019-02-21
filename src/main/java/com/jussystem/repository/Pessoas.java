package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.Pessoa;

public class Pessoas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pessoa porId(Long id) {
		return this.manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa>porNome(String nome){
		return this.manager.createQuery("from Pessoa "+
				"where upper(nome) like :nome", Pessoa.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}
}
