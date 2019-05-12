package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.FormaPagamento;
import com.jussystem.repository.FormaPagamentos;
import com.jussystem.util.jpa.Transactional;

public class CadastroFormaPagamentoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FormaPagamentos formaPagamentos;
	
	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
	    FormaPagamento formaPagamentoExistente = formaPagamentos.porNome(formaPagamento.getDescricao());
		if(formaPagamentoExistente !=null && !formaPagamentoExistente.equals(formaPagamento)) {
			throw new NegocioException("Já existe um Forma de pagamento com esta descrição cadastrado!");
		}
		 
		return 	formaPagamentos.guardar(formaPagamento);
		
	}

}
