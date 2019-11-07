package com.jussystem.repository;

import java.io.Serializable;
import java.util.Date;
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

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.StatusMovimentoSaidaProduto;
import com.jussystem.repository.filter.MovimentoSaidaProdutoFilter;

public class MovimentoSaidaProdutos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public List<MovimentoSaidaProduto> buscarMovimentos(){
		return manager.createQuery("from MovimentoSaidaProduto", MovimentoSaidaProduto.class).getResultList();
	}
	
	public MovimentoSaidaProduto guardar(MovimentoSaidaProduto movimentoSaidaProduto){
		return manager.merge(movimentoSaidaProduto);
	}
	
	public MovimentoSaidaProduto porNomeDoMovimento(String movimentoSaidaProduto) {
		try {
		return manager.createQuery("from MovimentoSaidaProduto where upper(movimentoSaidaProduto) = :movimentoSaidaProduto", MovimentoSaidaProduto.class)
				.setParameter("movimentoSaidaProduto", movimentoSaidaProduto.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public List<MovimentoSaidaProduto> porMovimentosSaidasProdutos(String descricao) {
		return this.manager.createQuery("from MovimentoSaidaProduto " +
				"where upper(movimentoSaidaProduto) like :movimentoSaidaProduto", MovimentoSaidaProduto.class)
				.setParameter("movimentoSaidaProduto", descricao.toUpperCase() + "%")
				.getResultList();
	}
	
	public List<MovimentoSaidaProduto> filtradosAtivo(String nomeProduto, Long codigo, Date data){
		return this.manager.createQuery("from MovimentoSaidaProduto " +
				"where upper(nomeProduto) like :nome"+
				" and data like :dataSaida"+
				" and codigo like :id"+
				" and status like :statusMovimentoSaidaProduto", MovimentoSaidaProduto.class)
				.setParameter("nome", nomeProduto.toUpperCase() + "%")
				.setParameter("id", codigo + "%")
				.setParameter("dataSaida", data + "%")
				.setParameter("statusMovimentoSaidaProduto", StatusMovimentoSaidaProduto.ATIVO)
				.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<MovimentoSaidaProduto>filtradas(MovimentoSaidaProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoSaidaProduto.class)
				.createAlias("usuario", "u")
				.createAlias("produto", "p");
		
		if(filtro.getNumeroDe() != null){
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}
		
		if(filtro.getNumeroAte() != null){
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if (filtro.getDataSaidaDe() != null) {
			criteria.add(Restrictions.ge("dataSaida", filtro.getDataSaidaDe()));
		}
		
		if (filtro.getDataSaidaAte() != null) {
			criteria.add(Restrictions.le("dataSaida", filtro.getDataSaidaAte()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNomeUsuario())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "f", criado anteriormente
			criteria.add(Restrictions.ilike("u.nome", filtro.getNomeUsuario(), MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeProduto())){
			criteria.add(Restrictions.ilike("p.nome", filtro.getNomeProduto(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes
			// da enum StatusPedido
			criteria.add(Restrictions.in("statusMovimentoSaidaProduto", filtro.getStatuses()));
		
		}
		return criteria.addOrder(Order.asc("id")).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MovimentoSaidaProduto>filtradasAtivo(MovimentoSaidaProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoSaidaProduto.class)
				.createAlias("usuario", "u")
				.createAlias("produto", "p");
		
		if(filtro.getNumeroDe() != null){
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}
		
		if(filtro.getNumeroAte() != null){
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if (filtro.getDataSaidaDe() != null) {
			criteria.add(Restrictions.ge("dataSaida", filtro.getDataSaidaDe()));
		}
		
		if (filtro.getDataSaidaAte() != null) {
			criteria.add(Restrictions.le("dataSaida", filtro.getDataSaidaAte()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNomeUsuario())) {
			// acessamos o nome do cliente associado ao pedido pelo alias "f", criado anteriormente
			criteria.add(Restrictions.ilike("u.nome", filtro.getNomeUsuario(), MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeProduto())){
			criteria.add(Restrictions.ilike("p.nome", filtro.getNomeProduto(), MatchMode.ANYWHERE));
		}
		
		
		
		return session.createCriteria(MovimentoSaidaProduto.class).
				add(Restrictions.eq("statusMovimentoSaidaProduto", StatusMovimentoSaidaProduto.ATIVO)).list();
		
		
		//return criteria.addOrder(Order.asc("id")).list();
	}


	public MovimentoSaidaProduto porId(Long id) {
		return manager.find(MovimentoSaidaProduto.class, id);
	}

	
}


