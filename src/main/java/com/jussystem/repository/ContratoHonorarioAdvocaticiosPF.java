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

import com.jussystem.model.ContratoHonorarioAdvocaticioPF;
import com.jussystem.repository.filter.ContratoHonorarioAdvocaticioPFFilter;


public class ContratoHonorarioAdvocaticiosPF implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public ContratoHonorarioAdvocaticioPF porId(Long id){
		return manager.find(ContratoHonorarioAdvocaticioPF.class, id);
	}
	
	public ContratoHonorarioAdvocaticioPF guardar(ContratoHonorarioAdvocaticioPF contratoHonorarioAdvocaticioPF) {
		return manager.merge(contratoHonorarioAdvocaticioPF);
	}
	
	public List<ContratoHonorarioAdvocaticioPF> buscarContratosHonorariosAdvocaticios() {
		return manager.createQuery("from ContratoHonorarioAdvocaticioPF", ContratoHonorarioAdvocaticioPF.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContratoHonorarioAdvocaticioPF> filtrados(ContratoHonorarioAdvocaticioPFFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(ContratoHonorarioAdvocaticioPF.class)
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
}
