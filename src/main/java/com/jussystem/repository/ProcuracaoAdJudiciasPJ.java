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

import com.jussystem.model.ProcuracaoAdJudiciaPJ;
import com.jussystem.repository.filter.ProcuracaoAdJudiciaPJFilter;

public class ProcuracaoAdJudiciasPJ implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ProcuracaoAdJudiciaPJ guardar(ProcuracaoAdJudiciaPJ procuracaoAdJudicia){
		return manager.merge(procuracaoAdJudicia);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcuracaoAdJudiciaPJ> filtradas(ProcuracaoAdJudiciaPJFilter filtro) {
        Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(ProcuracaoAdJudiciaPJ.class)
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



	public ProcuracaoAdJudiciaPJ porId(Long id) {
		return manager.find(ProcuracaoAdJudiciaPJ.class, id);
	}
	
	
}
