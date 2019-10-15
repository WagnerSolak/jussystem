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

import com.jussystem.model.Fornecedor;
import com.jussystem.model.MovimentoSaidaProduto;
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
	
	@SuppressWarnings("unchecked")
	public List<MovimentoSaidaProduto>filtradas(MovimentoSaidaProdutoFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(MovimentoSaidaProduto.class);
		
		if(filtro.getId() != null) {                                      
		criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("movimentoSaidaProduto", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("movimentoSaidaProduto")).list();
	}

	public MovimentoSaidaProduto porId(Long id) {
		return manager.find(MovimentoSaidaProduto.class, id);
	}

	
}


