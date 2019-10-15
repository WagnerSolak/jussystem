package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcuracaoAdJudiciaPJ;
import com.jussystem.repository.ProcuracaoAdJudiciasPJ;
import com.jussystem.util.jpa.Transactional;

public class CadastroProcuracaoAdJudiciaPJService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudiciasPJ procuracaoAdJudicias;
	
	@Transactional
	public ProcuracaoAdJudiciaPJ salvar(ProcuracaoAdJudiciaPJ procuracaoAdJudicia) {
			return procuracaoAdJudicias.guardar(procuracaoAdJudicia);
	}
	
}
