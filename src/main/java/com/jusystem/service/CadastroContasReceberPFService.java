package com.jusystem.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.jussystem.model.ContasReceberPF;
import com.jussystem.model.StatusContasReceber;
import com.jussystem.repository.ContasReceberPFRepository;
import com.jussystem.util.jpa.Transactional;

public class CadastroContasReceberPFService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContasReceberPFRepository contasReceberPF;
	
	@Transactional
	public ContasReceberPF salvar(ContasReceberPF contasReceberPF){
		
		if(contasReceberPF.isNovo()){
			contasReceberPF.setStatus(StatusContasReceber.ABERTO);
			contasReceberPF.setDataEmissao(new Date());
		}
		return this.contasReceberPF.guardar(contasReceberPF);
	}
}
