package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.TermoEntrevistaParaDemandaPJ;
import com.jussystem.repository.TermoEntrevistaParaDemandasPJ;
import com.jussystem.util.jpa.Transactional;

public class CadastroTermoEntrevistaParaDemandaPJService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TermoEntrevistaParaDemandasPJ termoEntrevistaParaDemandas;
	
	@Transactional
	public TermoEntrevistaParaDemandaPJ salvar(TermoEntrevistaParaDemandaPJ termoEntrevistaParaDemanda){
		return termoEntrevistaParaDemandas.guardar(termoEntrevistaParaDemanda);
	}
}
