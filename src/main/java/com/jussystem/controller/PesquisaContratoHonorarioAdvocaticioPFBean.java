package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ContratoHonorarioAdvocaticioPF;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPF;
import com.jussystem.repository.filter.ContratoHonorarioAdvocaticioPFFilter;


@Named
@ViewScoped
public class PesquisaContratoHonorarioAdvocaticioPFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContratoHonorarioAdvocaticiosPF contratoHonorarioAdvocaticiosPF;
	
	private ContratoHonorarioAdvocaticioPFFilter filtro;
	
	private List<ContratoHonorarioAdvocaticioPF> contratosPessoaFisicaFiltrados;
	
	public PesquisaContratoHonorarioAdvocaticioPFBean(){
		filtro = new ContratoHonorarioAdvocaticioPFFilter();
		contratosPessoaFisicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		contratosPessoaFisicaFiltrados = contratoHonorarioAdvocaticiosPF.filtrados(filtro);
	}
	
	public ContratoHonorarioAdvocaticioPFFilter getFiltro() {
		return filtro;
	}
	
	public List<ContratoHonorarioAdvocaticioPF> getContratosPessoaFisicaFiltrados() {
		return contratosPessoaFisicaFiltrados;
	}
	
}
