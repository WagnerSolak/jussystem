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

import com.jussystem.model.Cidade;
import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.repository.filter.ProcuracaoAdJudiciaFilter;

public class ProcuracaoAdJudicias implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ProcuracaoAdJudicia guardar(ProcuracaoAdJudicia procuracaoAdJudicia) {
		return manager.merge(procuracaoAdJudicia);
	}
	


	public List<Cidade>buscarCidades(){
		return manager.createQuery("from Cidades", Cidade.class).getResultList();
	}



	@SuppressWarnings("unchecked")
	public List<ProcuracaoAdJudicia> filtradas(ProcuracaoAdJudiciaFilter filtro) {
        Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(ProcuracaoAdJudicia.class)
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



	public ProcuracaoAdJudicia porId(Long id) {
		return manager.find(ProcuracaoAdJudicia.class, id);
	}
	
	
}
