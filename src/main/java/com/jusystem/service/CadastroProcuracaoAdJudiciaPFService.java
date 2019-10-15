package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcuracaoAdJudiciaPF;
import com.jussystem.repository.ProcuracaoAdJudiciasPF;
import com.jussystem.util.jpa.Transactional;

public class CadastroProcuracaoAdJudiciaPFService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudiciasPF procuracaoAdJudicias;
	
	@Transactional
	public ProcuracaoAdJudiciaPF salvar(ProcuracaoAdJudiciaPF procuracaoAdJudicia) {
			return procuracaoAdJudicias.guardar(procuracaoAdJudicia);
	}
}
