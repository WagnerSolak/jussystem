package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.CondicaoPagamento;
import com.jussystem.model.NaturezaProcesso;
import com.jussystem.model.ProcessoPF;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPF;
import com.jussystem.util.jpa.Transactional;

public class CadastroProcessoPFService implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcessosPF processos;
	
	@Transactional
	public ProcessoPF salvar(ProcessoPF processo) {
		
		ProcessoPF processoExistente = processos.porNumeroProcesso(processo.getNumeroProcesso());
		if(processoExistente != null && !processoExistente.equals(processo)){
			throw new NegocioException("Já existe um processo com este número cadastrado!");
		}
		
		if(processo.isNovo()){
			processo.setStatusProcesso(StatusProcesso.ANDAMENTO);
			
		}
		
		if(processo.isValorRecebimentoClienteNegativo()){
			throw new NegocioException("O valor recebimento cliente não pode ser negativo!");
		}
		
		if(processo.isValorLiquidoNegativo()){
			throw new NegocioException("O valor total líquido não pode ser negativo!");
		}
		
		if(processo.getNaturezaProcesso().equals(NaturezaProcesso.CIVIL)){
			processo.setCondicaoPagamento(CondicaoPagamento.APRAZO);
		}
		
		if(processo.getNaturezaProcesso().equals(NaturezaProcesso.TRABALHO)){
			processo.setCondicaoPagamento(CondicaoPagamento.AVISTA);
		}
			return processos.guardar(processo);
	}
	
	
	
	
}
