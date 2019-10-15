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


import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.repository.filter.MotivoSaidaProdutoFilter;

public class MotivoSaidaProdutos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public List<MotivoSaidaProduto> buscarMotivos(){
		return manager.createQuery("from MotivoSaidaProduto", MotivoSaidaProduto.class).getResultList();
	}
	
	public MotivoSaidaProduto guardar(MotivoSaidaProduto motivoSaidaProduto){
		return manager.merge(motivoSaidaProduto);
	}
	
	public MotivoSaidaProduto porNomeDoMotivo(String motivoSaida) {
		try {
		return manager.createQuery("from MotivoSaidaProduto where upper(motivoSaida) = :motivoSaida", MotivoSaidaProduto.class)
				.setParameter("motivoSaida", motivoSaida.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public List<MotivoSaidaProduto> porMotivosSaidasProdutos(String descricao) {
		return this.manager.createQuery("from MotivoSaidaProduto " +
				"where upper(motivoSaida) like :motivoSaida", MotivoSaidaProduto.class)
				.setParameter("motivoSaida", descricao.toUpperCase() + "%")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<MotivoSaidaProduto>filtradas(MotivoSaidaProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MotivoSaidaProduto.class);
		
		if(filtro.getId() != null) {                                      
		criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("motivoSaida", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("motivoSaida")).list();
	}

	public MotivoSaidaProduto porId(Long id) {
		return manager.find(MotivoSaidaProduto.class, id);
	}
}
