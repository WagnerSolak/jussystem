package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.repository.ClientePessoaJuridicas;
import com.jussystem.util.jpa.Transactional;

public class CadastroClientePessoaJuridicaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientePessoaJuridicas clientePessoaJuridicas;
	
	@Transactional
	public ClientePessoaJuridica salvar(ClientePessoaJuridica clientePessoaJuridica){
		/*ClientePessoaJuridica clientePessoaJuridicaExistente = clientePessoaJuridicas.porNome(clientePessoaJuridica.getNomeContratante());
		if(clientePessoaJuridicaExistente != null && !clientePessoaJuridicaExistente.equals(clientePessoaJuridica)){
			throw new NegocioException("Já existe um cliente com este nome cadastrado no sistema!");
		}*/
		return clientePessoaJuridicas.guardar(clientePessoaJuridica);
	}
	
	
}

