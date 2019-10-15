package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ContratoHonorarioAdvocaticioPF;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPF;
import com.jussystem.util.jpa.Transactional;

public class CadastroContratoHonorarioAdvocaticioPFService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContratoHonorarioAdvocaticiosPF contratoHonorarioAdvocaticiosPF;
	
	@Transactional
	public ContratoHonorarioAdvocaticioPF salvar(ContratoHonorarioAdvocaticioPF contratoHonorarioAdvocaticioPF) {
			return contratoHonorarioAdvocaticiosPF.guardar(contratoHonorarioAdvocaticioPF);
	}
	
	
}
