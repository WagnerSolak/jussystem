package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcessoPJ;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPJ;
import com.jussystem.util.jpa.Transactional;

public class CancelamentoProcessoPJService implements Serializable{


	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessosPJ processosPJ;

	@Transactional
	public ProcessoPJ cancelar(ProcessoPJ processoPJ) {
		processoPJ = this.processosPJ.porId(processoPJ.getId());
		
		if(processoPJ.isNaoCancelavel()){
			throw new NegocioException("O processo não pode ser cancelado no status "+
					processoPJ.getStatusProcesso().getDescricao() +".");
		}
		
		processoPJ.setStatusProcesso(StatusProcesso.CANCELADO);
		
		processoPJ = this.processosPJ.guardar(processoPJ);
		
		return processoPJ;
	}
}
