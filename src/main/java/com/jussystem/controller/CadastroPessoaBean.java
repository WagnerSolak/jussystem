package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jussystem.model.Cidade;
import com.jussystem.model.Pessoa;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private Cidade cidade;
	
	
	public CadastroPessoaBean() {
		pessoa = new Pessoa();
		cidade = new Cidade();
		
		
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

}
