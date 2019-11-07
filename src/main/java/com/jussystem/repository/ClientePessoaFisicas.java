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

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.repository.filter.ClientePessoaFisicaFilter;


public class ClientePessoaFisicas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ClientePessoaFisica porId(Long id) {
		return manager.find(ClientePessoaFisica.class, id);
	}

	public ClientePessoaFisica guardar(ClientePessoaFisica clientePessoaFisica) {
		return manager.merge(clientePessoaFisica);
	}

	public ClientePessoaFisica porNome(String nomePessoa) {// depreciar pois
															// pode haver dois
															// nomes iguais
		try {
			return manager
					.createQuery(
							"from ClientePessoaFisica where upper(nomePessoa) = :nomePessoa",
							ClientePessoaFisica.class)
					.setParameter("nomePessoa", nomePessoa.toUpperCase())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<ClientePessoaFisica> porNomeSelecao(String nomePessoa) {
		return this.manager
				.createQuery(
						"From ClientePessoaFisica "
								+ "where upper(nomePessoa) like :nomePessoa",
						ClientePessoaFisica.class)
				.setParameter("nomePessoa", nomePessoa.toUpperCase() + "%")
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<ClientePessoaFisica> filtrados(ClientePessoaFisicaFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ClientePessoaFisica.class);

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
			criteria.add(Restrictions.ge("dataCadastro",
					filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCadastro",
					filtro.getDataCriacaoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nomePessoa", filtro.getNome(),
					MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(filtro.getRg())) {
			criteria.add(Restrictions.ilike("rg", filtro.getRg(),
					MatchMode.ANYWHERE));
		}
		
		if (filtro.getDataNascimento() != null) {
			criteria.add(Restrictions.eq("dataNascimento", filtro.getDataNascimento()));
		}
		
		if(StringUtils.isNotBlank(filtro.getCpf())){
			criteria.add(Restrictions.ilike("cpf", filtro.getCpf()));
		}

		return criteria.addOrder(Order.asc("nomePessoa")).list();
	}

}
