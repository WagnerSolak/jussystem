package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.TermoEntrevistaParaDemandaPF;
import com.jussystem.repository.TermoEntrevistaParaDemandasPF;
import com.jussystem.util.jpa.Transactional;

public class CadastroTermoEntrevistaParaDemandaPFService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TermoEntrevistaParaDemandasPF termoEntrevistaParaDemandas;
	
	@Transactional
	public TermoEntrevistaParaDemandaPF salvar(TermoEntrevistaParaDemandaPF termoEntrevistaParaDemanda){
		return termoEntrevistaParaDemandas.guardar(termoEntrevistaParaDemanda);
	}
}
