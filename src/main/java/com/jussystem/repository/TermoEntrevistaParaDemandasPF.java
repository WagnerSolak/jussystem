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


import com.jussystem.model.TermoEntrevistaParaDemandaPF;
import com.jussystem.repository.filter.TermoEntrevistaParaDemandaPFFilter;

public class TermoEntrevistaParaDemandasPF implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public TermoEntrevistaParaDemandaPF guardar(TermoEntrevistaParaDemandaPF termoEntrevistaParaDemanda){
		return manager.merge(termoEntrevistaParaDemanda);
	}
	
	public List<TermoEntrevistaParaDemandaPF> buscarTermosEntrevistaParaDemanda() {
		return manager.createQuery("from TermoEntrevistaParaDemanda", TermoEntrevistaParaDemandaPF.class).getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TermoEntrevistaParaDemandaPF> filtradas(TermoEntrevistaParaDemandaPFFilter filtro) {
        Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(TermoEntrevistaParaDemandaPF.class)
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
	
	
	
	public TermoEntrevistaParaDemandaPF porId(Long id) {
		return manager.find(TermoEntrevistaParaDemandaPF.class, id);
	}
}
