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

import com.jussystem.model.Cargo;
import com.jussystem.repository.filter.CargoFilter;


public class Cargos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Cargo> buscarCargos(){
		return manager.createQuery("from Cargo", Cargo.class).getResultList();
	}
	
	public Cargo guardar(Cargo cargo){
		return manager.merge(cargo);
	}
	
	public Cargo porNomeDoCargo(String cargoEmpresa) {
		try {
		return manager.createQuery("from Cargo where upper(cargoEmpresa) = :cargoEmpresa", Cargo.class)
				.setParameter("cargoEmpresa", cargoEmpresa.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Cargo> porNomeCargos(String descricao) {
		return this.manager.createQuery("from Cargo " +
				"where upper(cargoEmpresa) like :cargoEmpresa", Cargo.class)
				.setParameter("cargoEmpresa", descricao.toUpperCase() + "%")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo>filtradas(CargoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cargo.class);
		
		if(filtro.getId() != null) {                                      
		criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("cargoEmpresa", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("cargoEmpresa")).list();
	}

	public Cargo porId(Long id) {
		return manager.find(Cargo.class, id);
	}
}
