package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.repository.DeclaracaoJusticaGratuitas;
import com.jussystem.util.jpa.Transactional;

public class CadastroDeclaracaoJusticaGratuitaService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitas declaracaoJusticaGratuitas;
	
	@Transactional
	public DeclaracaoJusticaGratuita salvar(DeclaracaoJusticaGratuita declaracaoJusticaGratuita) {
			return declaracaoJusticaGratuitas.guardar(declaracaoJusticaGratuita);
	}
}