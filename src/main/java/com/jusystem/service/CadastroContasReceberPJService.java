package com.jusystem.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.jussystem.model.ContasReceberPJ;
import com.jussystem.model.StatusContasReceber;
import com.jussystem.repository.ContasReceberPJRepository;
import com.jussystem.util.jpa.Transactional;

public class CadastroContasReceberPJService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContasReceberPJRepository contasReceberPJ;
	
	@Transactional
	public ContasReceberPJ salvar(ContasReceberPJ contasReceberPJ){
		
		if(contasReceberPJ.isNovo()){
			contasReceberPJ.setStatus(StatusContasReceber.ABERTO);
			contasReceberPJ.setDataEmissao(new Date());
			
		}
		return this.contasReceberPJ.guardar(contasReceberPJ);
	}
}
