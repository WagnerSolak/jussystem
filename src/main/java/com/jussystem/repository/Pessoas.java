package com.jussystem.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.jussystem.model.Pessoa;
import com.jussystem.repository.filter.PessoaFilter;
import com.jussystem.util.jpa.Transactional;
import com.jusystem.service.NegocioException;

public class Pessoas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pessoa porId(Long id) {
		return this.manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa>porNome(String nomePessoa){
		return this.manager.createQuery("from Pessoa "+
				"where upper(nomePessoa) like :nomePessoa", Pessoa.class)
				.setParameter("nomePessoa", nomePessoa.toUpperCase() + "%")
				.getResultList();
	}

	public Pessoa guardar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}
	
	public List<Pessoa>filtradas(PessoaFilter filtro){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = builder.createQuery(Pessoa.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Pessoa> pessoaRoot = criteriaQuery.from(Pessoa.class);
		
		if(StringUtils.isNotBlank(filtro.getDocumentoReceitaFederal())) {
			predicates.add(builder.equal(pessoaRoot.get("documentoReceitaFederal"), filtro.getDocumentoReceitaFederal()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(pessoaRoot.get("nomePessoa")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		criteriaQuery.select(pessoaRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(pessoaRoot.get("nomePessoa")));
	
		TypedQuery<Pessoa>query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Transactional
	public void remover(Pessoa pessoa) throws NegocioException{
		try {
			pessoa = porId(pessoa.getId());
			manager.remove(pessoa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Pessoa não pode ser excluída, ela pode conter filhos!");
		}
		
	}
}
