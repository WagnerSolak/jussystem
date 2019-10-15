package com.jussystem.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.context.RequestContext;

import com.jussystem.model.Fornecedor;
import com.jussystem.repository.Fornecedores;


@Named
@ViewScoped
public class SelecaoFornecedorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores fornecedores;
	
	
	
	private String nome;
	
	private List<Fornecedor> fornecedoresFiltrados;
	
	
	public void pesquisar(){
		
			fornecedoresFiltrados = fornecedores.porNomeFantasia(nome);
		
		
	}
	
	public void selecionar(Fornecedor fornecedor){
		RequestContext.getCurrentInstance().closeDialog(fornecedor);
	}
	
	public void abrirDialogo(){
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
        opcoes.put("resizable", false);
        opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("/dialogos/SelecaoFornecedor", opcoes, null);
	}
	

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}
	
	
	
}
