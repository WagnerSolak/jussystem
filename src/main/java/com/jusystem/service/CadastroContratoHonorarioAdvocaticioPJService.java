package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ContratoHonorarioAdvocaticioPJ;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPJ;
import com.jussystem.util.jpa.Transactional;

public class CadastroContratoHonorarioAdvocaticioPJService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContratoHonorarioAdvocaticiosPJ contratoHonorarioAdvocaticiosPJ;
	
	@Transactional
	public ContratoHonorarioAdvocaticioPJ salvar(ContratoHonorarioAdvocaticioPJ contratoHonorarioAdvocaticioPJ) {
			return contratoHonorarioAdvocaticiosPJ.guardar(contratoHonorarioAdvocaticioPJ);
	}
}
