package com.jussystem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.Produto;

public class Produtos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}
}
