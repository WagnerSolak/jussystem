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

import com.jussystem.model.ProcessoPJ;
import com.jussystem.repository.filter.ProcessoPJFilter;

public class ProcessosPJ implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public ProcessoPJ porId(Long id) {
		return this.manager.find(ProcessoPJ.class, id);
	}
	
	public ProcessoPJ guardar(ProcessoPJ processo){
		return manager.merge(processo);
	}


	public ProcessoPJ porNumeroProcesso(String numeroProcesso) {
		try{
			return manager.createQuery("from ProcessoPJ where numeroProcesso = :numeroProcesso", ProcessoPJ.class)
					.setParameter("numeroProcesso", numeroProcesso).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<ProcessoPJ> filtrados(ProcessoPJFilter filtro){
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(ProcessoPJ.class)
				.createAlias("clientePessoaJuridica", "cpj");
		
		if(filtro.getNumeroDe() != null){
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}
		
		if(filtro.getNumeroAte() != null){
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if(filtro.getDataProcessoDe() != null){
			criteria.add(Restrictions.ge("dataEntrada", filtro.getDataProcessoDe()));
		}
		
		if(filtro.getDataProcessoAte() != null){
			criteria.add(Restrictions.le("dataEntrada", filtro.getDataProcessoAte()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomePessoa())){
			criteria.add(Restrictions.ilike("cpj.nomeContratante", filtro.getNomePessoa(),MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(filtro.getNumeroProcesso())){
			criteria.add(Restrictions.ilike("numeroProcesso", filtro.getNumeroProcesso(),MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("statusProcesso", filtro.getStatuses()));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

}


