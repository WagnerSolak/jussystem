package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.apache.commons.lang3.StringUtils;

import com.jussystem.model.DeclaracaoJusticaGratuitaPF;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaPFFilter;



public class DeclaracaoJusticaGratuitasPF implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public DeclaracaoJusticaGratuitaPF guardar(DeclaracaoJusticaGratuitaPF declaracaoJusticaGratuita) {
		return manager.merge(declaracaoJusticaGratuita);
	}
	
	public List<DeclaracaoJusticaGratuitaPF> buscarDeclaracoesJusticaGratuita() {
		return manager.createQuery("from DeclaracaoJusticaGratuita", DeclaracaoJusticaGratuitaPF.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DeclaracaoJusticaGratuitaPF> filtrados(DeclaracaoJusticaGratuitaPFFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(DeclaracaoJusticaGratuitaPF.class)
				.createAlias("clientePessoaFisica", "cpf");
		
		if(filtro.getNumeroDe() != null){
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}
		
		if(filtro.getNumeroAte() != null){
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if(filtro.getDataDocumentoDe() != null){
			criteria.add(Restrictions.ge("dataDocumento", filtro.getDataDocumentoDe()));
		}
		
		if(filtro.getDataDocumentoAte() != null){
			criteria.add(Restrictions.le("dataDocumento", filtro.getDataDocumentoAte()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomePessoa())){
			criteria.add(Restrictions.ilike("cpf.nomePessoa", filtro.getNomePessoa(),MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

	public DeclaracaoJusticaGratuitaPF porId(Long id) {
		return manager.find(DeclaracaoJusticaGratuitaPF.class, id);
	}
	
	 
}
