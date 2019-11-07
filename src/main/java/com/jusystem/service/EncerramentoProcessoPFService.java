package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcessoPF;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPF;
import com.jussystem.util.jpa.Transactional;


public class EncerramentoProcessoPFService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcessosPF processosPF;
	
	
	
	@Inject
	private CadastroProcessoPFService cadastroProcessoPFService;
	
	@Transactional
	public ProcessoPF encerrar(ProcessoPF processoPF) throws Exception{
		processoPF = this.cadastroProcessoPFService.salvar(processoPF);
		
		if(processoPF.isNaoEncerravelZerado()){
			throw new NegocioException("Processo não pode ser encerrado sem Valor Total * zerado!");
		}
		
		if(processoPF.isNaoEncerravelPercentualZerado()){
			throw new NegocioException("Processo não pode ser encerrado sem Percentual * zerado!");
		}
		
		if(processoPF.isNaoEncerravel()){
			throw new NegocioException("Processo não pode ser encerrado com status"
					+ processoPF.getStatusProcesso().getDescricao() + ".");
		}
		
		
		
		processoPF.setStatusProcesso(StatusProcesso.ENCERRADO);
		
		processoPF = this.processosPF.guardar(processoPF);
		
		return processoPF;
	}
}
