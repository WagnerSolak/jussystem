package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Profissao;
import com.jussystem.repository.Profissoes;
import com.jussystem.util.jpa.Transactional;

public class CadastroProfissaoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Profissoes profissoes;
	
	@Transactional
	public Profissao salvar(Profissao profissao){
		Profissao profissaoExistente = profissoes.porNomeProfissao(profissao.getDescricao());
		
		if(profissaoExistente != null && !profissaoExistente.equals(profissao)){
			throw new NegocioException("Já existe uma profissão com a descrição informada!");
		}
		return profissoes.guardar(profissao);
	}
}
