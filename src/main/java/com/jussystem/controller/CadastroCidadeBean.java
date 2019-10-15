package com.jussystem.controller;

import java.io.Serializable;




import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cidade;
import com.jussystem.model.UfCliente;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroCidadeService;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCidadeService cadastroCidadeService;
	
	private Cidade cidade;
	
	
	public CadastroCidadeBean() {
		limpar();
		
	}
	
	public void inicializar() {
		if(cidade == null){
			limpar();
		}
	}
	
	public void salvar() {
		cidade = cadastroCidadeService.salvar(cidade);
		FacesUtil.addInfoMessage("Cidade: " +cidade.getNome()+" - "+cidade.getUfCliente()+", salva com sucesso!");
		limpar();
		
	}	
	
	public boolean isEditando() {
		return this.cidade.getId() != null;
	}
	
	public void limpar() {
		cidade = new Cidade();
		
	}
	

	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public UfCliente[] getUfsCliente(){
		return UfCliente.values();
	}
	
	
	

	
	
}
