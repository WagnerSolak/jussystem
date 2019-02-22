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

import com.jussystem.model.Cidade;
import com.jussystem.repository.filter.CidadeFilter;


public class Cidades implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Cidade> buscarCidades(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	public Cidade guardar(Cidade cidade) {
		return  manager.merge(cidade);

	}

	public Cidade porNome(String nome) {
		try {
		return manager.createQuery("from Cidade where upper(nome) = :nome", Cidade.class)
				.setParameter("nome", nome.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade>filtradas(CidadeFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cidade.class);
		
		if(filtro.getId() != null) {                                      
		criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Cidade porId(Long id) {
		return this.manager.find(Cidade.class, id);
	}
}
