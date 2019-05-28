package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.InativaPessoa;
import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;
import com.jussystem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class MovimentoInativaPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Pessoa pessoa;
	
	@Inject
	private Pessoas pessoas;
	
	private InativaPessoa inativaPessoa;
	
	List<Pessoa> listaDePEssoas;
	
	public List<Pessoa> completarPessoa(String nome) {
		return this.pessoas.porNomeAtivas(nome);
		}
		
	
	public void inicializar(){
		if(FacesUtil.isPostBack()){
			
		}
	}
	
	public MovimentoInativaPessoaBean(){
		limpar();
	}
	
	public void limpar(){
		inativaPessoa = new InativaPessoa();
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setInativaPessoa(InativaPessoa inativaPessoa) {
		this.inativaPessoa = inativaPessoa;
	}
	
	public InativaPessoa getInativaPessoa() {
		return inativaPessoa;
	}
	
	
}
