package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ProcessoPJ;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPJ;
import com.jussystem.util.jpa.Transactional;



public class EdicaoProcessoPJService implements Serializable{

	@Inject
	private ProcessosPJ processosPJ;
	
	@Inject
	private CadastroProcessoPJService cadastroProcessoPJService;
	
	private static final long serialVersionUID = 1L;

	@Transactional
	public ProcessoPJ encerrar(ProcessoPJ processoPJ){

		processoPJ = this.cadastroProcessoPJService.salvar(processoPJ);
		
		if(processoPJ.isNaoEncerravel()){
			throw new NegocioException("Processo não pode ser encerrado no status " 
					+ processoPJ.getStatusProcesso().getDescricao() + ". Verifique também se os campos Valor Total * e Percentual * foram preenchidos!");
					
		}
		
		
		processoPJ.setStatusProcesso(StatusProcesso.ENCERRADO);
		
		processoPJ = this.processosPJ.guardar(processoPJ);
		
		return processoPJ;
	}
}
