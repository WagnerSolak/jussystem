package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jussystem.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioExistente = usuarios.porNome(usuario.getNome());
		
		if(usuarioExistente != null && !usuarioExistente.equals(usuario) ) {
			throw new NegocioException("Já existe um usuário com a descrição informada!");
		}
		return usuarios.guardar(usuario);
	}
}
