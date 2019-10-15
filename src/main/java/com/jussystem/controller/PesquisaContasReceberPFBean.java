package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ContasReceberPF;
import com.jussystem.model.StatusContasReceber;
import com.jussystem.repository.ContasReceberPFRepository;
import com.jussystem.repository.filter.ContasReceberPFFilter;

@Named
@ViewScoped
public class PesquisaContasReceberPFBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContasReceberPFRepository contasReceberPFRepository;
	
	private ContasReceberPFFilter filtro;
	
	private List<ContasReceberPF> contasReceberPessoaFisicaFiltradas;
	
	public PesquisaContasReceberPFBean(){
		filtro = new ContasReceberPFFilter();
		contasReceberPessoaFisicaFiltradas = new ArrayList<>();
	}
	
	public void pesquisar(){
		contasReceberPessoaFisicaFiltradas = contasReceberPFRepository.filtrados(filtro);
	}
	
	public StatusContasReceber[] getStatuses() {
		return StatusContasReceber.values();
	}
	
	public List<ContasReceberPF> getContasReceberPessoaFisicaFiltradas() {
		return contasReceberPessoaFisicaFiltradas;
	}
	
	public ContasReceberPFFilter getFiltro() {
		return filtro;
	}
}
