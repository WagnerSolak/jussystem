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

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.repository.filter.ClientePessoaJuridicaFilter;

public class ClientePessoaJuridicas implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	
	
	public ClientePessoaJuridica porId(Long id) {
		return manager.find(ClientePessoaJuridica.class, id);
	}
	
	public ClientePessoaJuridica guardar(ClientePessoaJuridica clientePessoaJuridica){
		return manager.merge(clientePessoaJuridica);
	}


	public ClientePessoaJuridica porNome(String nomeContratante) {
		try {
			return manager
					.createQuery(
							"from ClientePessoaJuridica where upper(nomeContratante) = :nomeContratante",
							ClientePessoaJuridica.class)
					.setParameter("nomeContratante", nomeContratante.toUpperCase())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<ClientePessoaJuridica> porNomeSelecao(String nomeContratante) {
		return this.manager
				.createQuery(
						"From ClientePessoaJuridica "
								+ "where upper(nomeContratante) like :nomeContratante",
						ClientePessoaJuridica.class)
				.setParameter("nomeContratante", nomeContratante.toUpperCase() + "%")
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<ClientePessoaJuridica> filtrados(ClientePessoaJuridicaFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ClientePessoaJuridica.class);

		if (filtro.getNumeroDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a
			// filtro.numeroDe
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a
			// filtro.numeroDe
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}

		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("dataCriacao",
					filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCriacao",
					filtro.getDataCriacaoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nomeContratante", filtro.getNome(),
					MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getCnpj())) {
			criteria.add(Restrictions.ilike("cnpj", filtro.getCnpj(),
					MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nomeContratante")).list();
	}

}
