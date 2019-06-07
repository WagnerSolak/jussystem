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





import com.jussystem.model.Categoria;
import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaFilter;



public class DeclaracaoJusticaGratuitas implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public DeclaracaoJusticaGratuita guardar(DeclaracaoJusticaGratuita declaracaoJusticaGratuita) {
		return manager.merge(declaracaoJusticaGratuita);
	}
	
	public List<DeclaracaoJusticaGratuita> buscarDeclaracoesJusticaGratuita() {
		return manager.createQuery("from DeclaracaoJusticaGratuita", DeclaracaoJusticaGratuita.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DeclaracaoJusticaGratuita> filtrados(DeclaracaoJusticaGratuitaFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(DeclaracaoJusticaGratuita.class)
				.createAlias("pessoa", "p");
		
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
			criteria.add(Restrictions.ilike("p.nomePessoa", filtro.getNomePessoa(),MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

	public DeclaracaoJusticaGratuita porId(Long id) {
		return manager.find(DeclaracaoJusticaGratuita.class, id);
	}
	
	 
}
