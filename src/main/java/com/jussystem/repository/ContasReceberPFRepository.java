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

import com.jussystem.model.CondicaoDePagamento;
import com.jussystem.model.CondicaoPagamento;
import com.jussystem.model.ContasReceberPF;
import com.jussystem.repository.filter.ContasReceberPFFilter;



public class ContasReceberPFRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public ContasReceberPF porId(Long id) {
		return manager.find(ContasReceberPF.class, id);
	}
	
	public ContasReceberPF guardar(ContasReceberPF contasReceberPF){
		if(contasReceberPF.getCondicaoPagamento() == null){
			contasReceberPF.setCondicaoPagamento(CondicaoPagamento.AVISTA);
		}
		return manager.merge(contasReceberPF);
	}

	@SuppressWarnings("unchecked")
	public List<ContasReceberPF> filtrados(ContasReceberPFFilter filtro) {
		Session session = this.manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(ContasReceberPF.class)
				.createAlias("clientePessoaFisica", "cpf");

		if (filtro.getNumeroDe() != null) {
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}

		if (filtro.getDataContasReceberDe() != null) {
			criteria.add(Restrictions.ge("dataEmissao",
					filtro.getDataContasReceberDe()));
		}

		if (filtro.getDataContasReceberAte() != null) {
			criteria.add(Restrictions.le("dataEmissao",
					filtro.getDataContasReceberAte()));
		}
		
		if (filtro.getDataPagamentoDe() != null) {
			criteria.add(Restrictions.ge("dataPagamento",
					filtro.getDataPagamentoDe()));
		}

		if (filtro.getDataPagamentoAte() != null) {
			criteria.add(Restrictions.le("dataPagamento",
					filtro.getDataPagamentoAte()));
		}
		
		if (filtro.getDataVencimentoDe() != null) {
			criteria.add(Restrictions.ge("dataVencimento",
					filtro.getDataVencimentoDe()));
		}

		if (filtro.getDataVencimentoAte() != null) {
			criteria.add(Restrictions.le("dataVencimento",
					filtro.getDataVencimentoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNomePessoa())) {
			criteria.add(Restrictions.ilike("cpf.nomePessoa",
					filtro.getNomePessoa(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getNumeroProcesso())) {
			criteria.add(Restrictions.ilike("numeroProcesso",
					filtro.getNumeroProcesso(), MatchMode.ANYWHERE));
		}

		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			criteria.add(Restrictions.in("statusContasReceber", filtro.getStatuses()));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

	
	
}
