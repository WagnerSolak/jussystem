package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.DeclaracaoJusticaGratuitaPJ;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPJ;
import com.jussystem.util.jpa.Transactional;

public class CadastroDeclaracaoJusticaGratuitaPJService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitasPJ declaracaoJusticaGratuitas;
	
	@Transactional
	public DeclaracaoJusticaGratuitaPJ salvar(DeclaracaoJusticaGratuitaPJ declaracaoJusticaGratuita) {
			return declaracaoJusticaGratuitas.guardar(declaracaoJusticaGratuita);
	}
}
