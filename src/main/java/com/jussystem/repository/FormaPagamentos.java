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

import com.jussystem.model.FormaPagamento;
import com.jussystem.repository.filter.FormaPagamentoFilter;

public class FormaPagamentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public List<FormaPagamento> formaPagamentos(){
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	public FormaPagamento porNome(String descricao) {
		try {
			return manager.createQuery("from FormaPagamento where upper(descricao) = :descricao", FormaPagamento.class)
					.setParameter("descricao", descricao.toUpperCase()).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	
	}
	
	public FormaPagamento guardar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	
	@SuppressWarnings("unchecked")
	public List<FormaPagamento>filtrados(FormaPagamentoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FormaPagamento.class);
		
		
		if(filtro.getId() != null){
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("descricao")).list() ;
	}

	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	public List<FormaPagamento> porDescricao(String descricao){
		return this.manager.createQuery("from FormaPagamento where upper(descricao) like :descricao", FormaPagamento.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
}

