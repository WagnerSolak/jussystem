package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Profissao;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroProfissaoService;


@Named
@ViewScoped
public class CadastroProfissaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroProfissaoService cadastroProfissaoService;
	
	private Profissao profissao;
	
	public CadastroProfissaoBean(){
		limpar();
	}
	
	public void inicializar(){
		if(profissao == null){
			limpar();
		}
	}
	
	public void limpar(){
		profissao = new Profissao();
	}
	
	public void salvar() {
		profissao = cadastroProfissaoService.salvar(profissao);
		FacesUtil.addInfoMessage("Profissão: " +profissao.getDescricao()
				+ ", salva com sucesso!");
		limpar();
		
	}	
	
	public boolean isEditando() {
		return this.profissao.getId() != null;
	}

	
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	public Profissao getProfissao() {
		return profissao;
	}
	
}
