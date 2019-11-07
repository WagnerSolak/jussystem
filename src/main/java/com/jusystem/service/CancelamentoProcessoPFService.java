package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcessoPF;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPF;
import com.jussystem.util.jpa.Transactional;

public class CancelamentoProcessoPFService implements Serializable{


	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessosPF processosPF;

	
	@Transactional
	public ProcessoPF cancelar(ProcessoPF processoPF) throws Exception {
		processoPF = this.processosPF.porId(processoPF.getId());
		
		if(processoPF.isNaoCancelavel()){
			throw new NegocioException("Processo não pode ser cancelado no status "
					+processoPF.getStatusProcesso().getDescricao() + ".");
			
		}
			
			processoPF.setStatusProcesso(StatusProcesso.CANCELADO);
			
			processoPF = this.processosPF.guardar(processoPF);
		
		
		return processoPF;
	}

}
