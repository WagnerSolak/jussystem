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

import com.jussystem.model.Profissao;
import com.jussystem.repository.filter.ProfissaoFilter;

public class Profissoes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Profissao> buscarCargos(){
		return manager.createQuery("from Profissao", Profissao.class).getResultList();
	}
	
	public Profissao guardar(Profissao profissao){
		return manager.merge(profissao);
	}
	
	public Profissao porNomeProfissao(String descricao) {
		try {
		return manager.createQuery("from Profissao where upper(descricao) = :descricao", Profissao.class)
				.setParameter("descricao", descricao.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Profissao>filtradas(ProfissaoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Profissao.class);
		
		if(filtro.getId() != null) {                                      
		criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("descricao")).list();
	}

	public Profissao porId(Long id) {
		return manager.find(Profissao.class, id);
	}

	public List<Profissao> porNomeProfissoes(String descricao) {
		return this.manager.createQuery("from Profissao " +
				"where upper(descricao) like :descricao", Profissao.class)
				.setParameter("descricao", descricao.toUpperCase() + "%")
				.getResultList();
	}
}
