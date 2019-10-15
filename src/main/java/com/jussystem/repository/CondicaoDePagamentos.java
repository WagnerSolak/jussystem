package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.jussystem.model.CondicaoDePagamento;

public class CondicaoDePagamentos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public List<CondicaoDePagamento> porNomeCondicaoDePagamento(String descricao) {
		return this.manager.createQuery("from CondicaoDePagamento " +
				"where upper(descricao) like :descricao", CondicaoDePagamento.class)
				.setParameter("descricao", descricao.toUpperCase() + "%")
				.getResultList();
	}
	
	public CondicaoDePagamento porId(Long id) {
		return manager.find(CondicaoDePagamento.class, id);
	}
}
