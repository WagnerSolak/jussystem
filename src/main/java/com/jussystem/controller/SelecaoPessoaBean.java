package com.jussystem.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;

@Named
@ViewScoped
public class SelecaoPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoas pessoas;
	
	private String nome;
	
	private List<Pessoa> pessoasFiltradas;
	
	public void pesquisar(){
		pessoasFiltradas = pessoas.porNome(nome);
		
	}
	
	public void selecionar(Pessoa pessoa){
		RequestContext.getCurrentInstance().closeDialog(pessoa);
		
	}
	
	public void abrirDialogo(){
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", true);
        opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("/dialogos/SelecaoPessoa", opcoes, null);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}
}
