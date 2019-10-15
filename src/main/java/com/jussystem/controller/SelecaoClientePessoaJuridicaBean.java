package com.jussystem.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.jussystem.model.ClientePessoaJuridica;

import com.jussystem.repository.ClientePessoaJuridicas;

@Named
@ViewScoped
public class SelecaoClientePessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClientePessoaJuridicas clientePessoaJuridicas;

	private String nomeContratante;

	private List<ClientePessoaJuridica> clientesPessoaJuridicaFiltrados;

	public void pesquisar() {
		clientesPessoaJuridicaFiltrados = clientePessoaJuridicas
				.porNomeSelecao(nomeContratante);
	}

	public void selecionar(ClientePessoaJuridica clientePessoaJuridica) {
		RequestContext.getCurrentInstance().closeDialog(clientePessoaJuridica);
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog(
				"/dialogos/SelecaoClientePessoaJuridica", opcoes, null);
	}

	public List<ClientePessoaJuridica> getClientesPessoaJuridicaFiltrados() {
		return clientesPessoaJuridicaFiltrados;
	}

	public String getNomeContratante() {
		return nomeContratante;
	}

	public void setNomeContratante(String nomeContratante) {
		this.nomeContratante = nomeContratante;
	}
}
