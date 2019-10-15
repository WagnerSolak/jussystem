package com.jussystem.repository.filter;

import java.io.Serializable;

import com.jussystem.model.StatusFornecedor;



public class FornecedorFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String razao;
	private String cnpj;
	private StatusFornecedor[] statuses;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome == null ? null : nome.toUpperCase();
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao == null ? null : razao.toUpperCase();
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setStatuses(StatusFornecedor[] statuses) {
		this.statuses = statuses;
	}
	
	public StatusFornecedor[] getStatuses() {
		return statuses;
	}
	
	
	
	
}
