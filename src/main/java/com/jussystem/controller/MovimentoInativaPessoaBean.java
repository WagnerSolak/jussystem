package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.jussystem.model.InativaPessoa;
import com.jussystem.model.Pessoa;
import com.jussystem.model.StatusPessoa;
import com.jussystem.repository.InativaPessoas;
import com.jussystem.repository.Pessoas;
import com.jussystem.security.Seguranca;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroPessoaService;
import com.jusystem.service.MovimentoInativaPessoaService;

@Named
@ViewScoped
public class MovimentoInativaPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Seguranca seguranca;

	private InativaPessoa inativaPessoa;
	
	@Inject
	private CadastroPessoaService pessoaService;

	@Inject
	private Pessoa pessoa;

	@Inject
	private MovimentoInativaPessoaService inativaPessoaService;

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			limpar();
		}
	}

	public MovimentoInativaPessoaBean() {
		limpar();
	}

	public void pessoaSelecionada(SelectEvent event) {
		inativaPessoa.setPessoa((Pessoa) event.getObject());

	}

	public void inativarPessoa() {
		
		
		inativaPessoa.setDataHoraInativacao(new Date());
		inativaPessoa.setUsuarioLogado(seguranca.getNomeUsuario());
		inativaPessoa = inativaPessoaService.salvar(inativaPessoa);
		limpar();
		FacesUtil.addInfoMessage("Inativação da pessoa concluída com sucesso!");

	}
	


	public void limpar() {
		inativaPessoa = new InativaPessoa();
	}

	public void setInativaPessoa(InativaPessoa inativaPessoa) {
		this.inativaPessoa = inativaPessoa;
	}

	public InativaPessoa getInativaPessoa() {
		return inativaPessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
