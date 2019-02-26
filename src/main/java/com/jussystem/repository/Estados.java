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

import com.jussystem.model.Estado;
import com.jussystem.repository.filter.EstadoFilter;
import com.jussystem.util.jpa.Transactional;
import com.jusystem.service.NegocioException;

public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Estado> buscarEstados() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	public Estado guardar(Estado estado) {
		return manager.merge(estado);
	}

	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}

	public Estado porNome(String nome) {
		try {
			return manager.createQuery("from Estado where upper(nome) = :nome", Estado.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Estado> filtrados(EstadoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Estado.class);

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getSigla())) {
			criteria.add(Restrictions.ilike("sigla", filtro.getSigla(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	@Transactional
	public void remover(Estado estado) {
		try {
			estado = porId(estado.getId());
			manager.remove(estado);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Estado não pode ser excluído, ele pode conter filhos!");
		}
	}
}
