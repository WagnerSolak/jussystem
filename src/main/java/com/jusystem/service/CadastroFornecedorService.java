package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Fornecedor;
import com.jussystem.repository.Fornecedores;
import com.jussystem.util.jpa.Transactional;

public class CadastroFornecedorService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores fornecedores;
	
	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor){
		Fornecedor fornecedorExistente = fornecedores.porNome(fornecedor.getNomeFantasia());
		if(fornecedorExistente != null && !fornecedorExistente.equals(fornecedor)){
			throw new NegocioException("Já existe um fornecedor com este nome cadastrado no sistema!");
		}
		return fornecedores.guardar(fornecedor);
	}
	
	
	
}
