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

import com.jussystem.model.Fornecedor;
import com.jussystem.model.StatusFornecedor;
import com.jussystem.repository.filter.FornecedorFilter;

public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public List<Fornecedor> fornecedores(){
		return manager.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}
	
	public Fornecedor porNome(String nomeFantasia){
		try {
			return manager.createQuery("from Fornecedor where upper(nomeFantasia) = :nomeFantasia", Fornecedor.class)
					.setParameter("nomeFantasia", nomeFantasia.toUpperCase()).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Fornecedor> porNomeFantasia(String nomeFantasia){
		return this.manager.createQuery("from Fornecedor " +
				"where upper(nomeFantasia) like :nomeFantasia"+
				" and status like :status", Fornecedor.class)
				.setParameter("nomeFantasia", nomeFantasia.toUpperCase() + "%")
				.setParameter("status", StatusFornecedor.ATIVO)
				.getResultList();
	}
	
	public Fornecedor porId(Long id) {
		return manager.find(Fornecedor.class, id);
	}
	
	public Fornecedor guardar(Fornecedor fornecedor){
		return manager.merge(fornecedor);
	}

	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> filtrados(FornecedorFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Fornecedor.class);
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nomeFantasia", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getRazao())){
			criteria.add(Restrictions.ilike("razao", filtro.getRazao(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getCnpj())){
			criteria.add(Restrictions.ilike("cnpj", filtro.getCnpj(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusFornecedor
			criteria.add(Restrictions.in("status", filtro.getStatuses()));
		}
		
		return criteria.addOrder(Order.asc("nomeFantasia")).list();
	}

	
	

}
