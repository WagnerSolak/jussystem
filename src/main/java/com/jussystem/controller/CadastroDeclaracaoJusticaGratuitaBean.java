package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroDeclaracaoJusticaGratuitaService;

@Named
@ViewScoped
public class CadastroDeclaracaoJusticaGratuitaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DeclaracaoJusticaGratuita declaracaoJusticaGratuita;

	@Inject
	private Pessoas pessoas;

	@Inject
	private CadastroDeclaracaoJusticaGratuitaService cadastroDeclaracaoJusticaGratuitaService;

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			limpar();
		}

	}

	public Date dataHoje() {
		return new Date();
	}

	public void salvar() {
		declaracaoJusticaGratuita = cadastroDeclaracaoJusticaGratuitaService
				.salvar(declaracaoJusticaGratuita);
		limpar();
		FacesUtil.addInfoMessage("Declaração salva com sucesso!");
	}

	public List<Pessoa> completarPessoa(String nome) {
		return this.pessoas.porNome(nome);
	}

	public void pessoaSelecionada(SelectEvent event) {
		declaracaoJusticaGratuita.setPessoa((Pessoa) event.getObject());

	}

	public void limpar() {
		declaracaoJusticaGratuita = new DeclaracaoJusticaGratuita();
	}

	public void setDeclaracaoJusticaGratuita(
			DeclaracaoJusticaGratuita declaracaoJusticaGratuita) {
		this.declaracaoJusticaGratuita = declaracaoJusticaGratuita;
	}

	public DeclaracaoJusticaGratuita getDeclaracaoJusticaGratuita() {
		return declaracaoJusticaGratuita;
	}

	@NotBlank
	public String getNomePessoa() {
		return declaracaoJusticaGratuita.getPessoa() == null ? null
				: declaracaoJusticaGratuita.getPessoa().getNomePessoa();
	}

	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE
	public void setNomePessoa(String nomePessoa) {
	}
}
