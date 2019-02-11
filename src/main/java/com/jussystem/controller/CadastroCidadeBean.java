package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jussystem.model.Cidade;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Cidade cidade;
	
	public CadastroCidadeBean() {
		cidade = new Cidade();
	}
	
	public Cidade getCidade() {
		return cidade;
	}

}
