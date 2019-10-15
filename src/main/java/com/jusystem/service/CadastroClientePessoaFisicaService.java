package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.repository.ClientePessoaFisicas;
import com.jussystem.util.jpa.Transactional;

public class CadastroClientePessoaFisicaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientePessoaFisicas clientePessoaFisicas;
	
	@Transactional
	public ClientePessoaFisica salvar(ClientePessoaFisica clientePessoaFisica){
		
		
		return clientePessoaFisicas.guardar(clientePessoaFisica);
	}
	
	
}
