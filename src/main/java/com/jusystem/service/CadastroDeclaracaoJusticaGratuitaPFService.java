package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.DeclaracaoJusticaGratuitaPF;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPF;
import com.jussystem.util.jpa.Transactional;

public class CadastroDeclaracaoJusticaGratuitaPFService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitasPF declaracaoJusticaGratuitas;
	
	@Transactional
	public DeclaracaoJusticaGratuitaPF salvar(DeclaracaoJusticaGratuitaPF declaracaoJusticaGratuita) {
			return declaracaoJusticaGratuitas.guardar(declaracaoJusticaGratuita);
	}
}