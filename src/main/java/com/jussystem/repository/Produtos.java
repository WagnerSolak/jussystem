package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jussystem.model.Produto;
import com.jussystem.repository.filter.ProdutoFilter;
import com.jussystem.util.jpa.Transactional;
import com.jusystem.service.NegocioException;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	@Transactional
	public void remover(Produto produto) {
		try {
		produto = porId(produto.getId());
		manager.remove(produto);
		manager.flush();
		}catch(PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído, ele pode conter filhos!");
		}
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
	
	public List<Produto> porNomeLista(String nome) {
		return this.manager.createQuery("from Produto where upper(nome) like :nome", Produto.class)
					.setParameter("nome", nome.toUpperCase() + "%").getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto>filtrados(ProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if(StringUtils.isNotEmpty(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getNumeroDe() != null) {
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}
}
