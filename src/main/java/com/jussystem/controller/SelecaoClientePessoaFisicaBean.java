package com.jussystem.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.repository.ClientePessoaFisicas;



@Named
@ViewScoped
public class SelecaoClientePessoaFisicaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientePessoaFisicas clientePessoaFisicas;
	
	private String nomePessoa;
	
	private List<ClientePessoaFisica> cientesPessoaFisicaFiltrados;
	
	
	public void pesquisar(){
		cientesPessoaFisicaFiltrados = clientePessoaFisicas.porNomeSelecao(nomePessoa);
	}
	
	public void selecionar(ClientePessoaFisica	clientePessoaFisica){
		RequestContext.getCurrentInstance().closeDialog(clientePessoaFisica);
	}
	
	public void abrirDialogo(){
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
        opcoes.put("resizable", false);
        opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("/dialogos/SelecaoClientePessoaFisica", opcoes, null);
	}
	

	
	public void setNome(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	public String getNome() {
		return nomePessoa;
	}
	
	public List<ClientePessoaFisica> getCientesPessoaFisicaFiltrados() {
		return cientesPessoaFisicaFiltrados;
	}
	
}
