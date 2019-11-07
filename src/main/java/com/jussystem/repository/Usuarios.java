package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jussystem.model.Fornecedor;
import com.jussystem.model.StatusFornecedor;
import com.jussystem.model.StatusMovimentoSaidaProduto;
import com.jussystem.model.StatusUsuario;
import com.jussystem.model.Usuario;
import com.jussystem.repository.filter.UsuarioFilter;


public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarUsuarios() {
			return this.manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public List<Usuario> compradores() {//deu erro desta forma
		return this.manager.createQuery("from Usuario ", Usuario.class)
				.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> todosCompradoresAtivos(StatusUsuario ativo){
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("statusUsuario", ativo));
		List<Usuario> resultado = criteria.list();
		
		return resultado;
	}

	

	public Usuario porNome(String nome) {
		try {
			return manager.createQuery("from Usuario where upper(nome) = :nome", Usuario.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(UsuarioFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if (filtro.getNumeroDe() != null) {
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		
		if(StringUtils.isNotBlank(filtro.getEmail())){
			criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotEmpty(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("statusUsuario", filtro.getStatuses()));
		}
		return criteria.addOrder(Order.asc("nome")).list();

	}
	
	
	public Usuario porEmail(String email) {
		Usuario usuario = null;

		try {

			usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// Nenhum usuário encontrado com o e-mail informado
		}

		return usuario;
	}
}
