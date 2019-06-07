package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Processo;
import com.jussystem.repository.Processos;
import com.jussystem.util.jpa.Transactional;

public class CadastroProcessoService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private Processos processos;
	
	@Transactional
	public Processo salvar(Processo processo) {
			return processos.guardar(processo);
	}
}
