package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.repository.ProcuracaoAdJudicias;
import com.jussystem.util.jpa.Transactional;

public class CadastroProcuracaoAdJudiciaService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcuracaoAdJudicias procuracaoAdJudicias;
	
	@Transactional
	public ProcuracaoAdJudicia salvar(ProcuracaoAdJudicia procuracaoAdJudicia) {
			return procuracaoAdJudicias.guardar(procuracaoAdJudicia);
	}
}
