package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroDeclaracaoJusticaGratuitaService;

@Named
@ViewScoped
public class CadastroDeclaracaoJusticaGratuitaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DeclaracaoJusticaGratuita declaracaoJusticaGratuita;
	
	@Inject
	private CadastroDeclaracaoJusticaGratuitaService cadastroDeclaracaoJusticaGratuitaService;

	public void inicializar() {

	}

	public void salvar() {
		declaracaoJusticaGratuita = cadastroDeclaracaoJusticaGratuitaService.salvar(declaracaoJusticaGratuita);
		limpar();
		FacesUtil.addInfoMessage("Declaração salva com sucesso!");
	}

	public void limpar() {
		declaracaoJusticaGratuita = new DeclaracaoJusticaGratuita();
	}
}
