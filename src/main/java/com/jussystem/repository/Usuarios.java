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

import com.jussystem.model.Usuario;
import com.jussystem.repository.filter.UsuarioFilter;

public class Usuarios implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> compradores(){
		
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	public Usuario porNome(String nome) {
		try {
		return manager.createQuery("from Usuario where upper(nome) = :nome", Usuario.class)
				.setParameter("nome", nome.toUpperCase())
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(UsuarioFilter filtro){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
		
	}
}
