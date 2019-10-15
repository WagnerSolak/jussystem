package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jussystem.model.TermoEntrevistaParaDemandaPJ;
import com.jussystem.repository.filter.TermoEntrevistaParaDemandaPJFilter;

public class TermoEntrevistaParaDemandasPJ implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public TermoEntrevistaParaDemandaPJ guardar(TermoEntrevistaParaDemandaPJ termoEntrevistaParaDemanda){
		return manager.merge(termoEntrevistaParaDemanda);
	}
	
	public List<TermoEntrevistaParaDemandaPJ> buscarTermosEntrevistaParaDemanda() {
		return manager.createQuery("from TermoEntrevistaParaDemanda", TermoEntrevistaParaDemandaPJ.class).getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TermoEntrevistaParaDemandaPJ> filtradas(TermoEntrevistaParaDemandaPJFilter filtro) {
        Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(TermoEntrevistaParaDemandaPJ.class)
				.createAlias("clientePessoaJuridica", "cpj");
		
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
			criteria.add(Restrictions.ilike("cpj.nomePessoa", filtro.getNomePessoa(),MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}
	
	
	
	public TermoEntrevistaParaDemandaPJ porId(Long id) {
		return manager.find(TermoEntrevistaParaDemandaPJ.class, id);
	}
}

