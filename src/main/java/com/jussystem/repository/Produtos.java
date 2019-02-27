package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jussystem.model.Produto;
import com.jussystem.repository.filter.ProdutoFilter;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}

	public Produto porNome(String nome) {
		try {
			return manager.createQuery("from Produto where upper(nome) = :nome", Produto.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto>filtrados(ProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if(StringUtils.isNotEmpty(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		if(filtro.getId() != null) {
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
}
