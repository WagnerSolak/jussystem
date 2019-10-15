package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.ContratoHonorarioAdvocaticioPJ;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPJ;
import com.jussystem.repository.filter.ContratoHonorarioAdvocaticioPJFilter;


@Named
@ViewScoped
public class PesquisaContratoHonorarioAdvocaticioPJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContratoHonorarioAdvocaticiosPJ contratoHonorarioAdvocaticiosPJ;
	
	private ContratoHonorarioAdvocaticioPJFilter filtro;
	
	private List<ContratoHonorarioAdvocaticioPJ> contratosPessoaJurídicaFiltrados;
	
	public PesquisaContratoHonorarioAdvocaticioPJBean(){
		filtro = new ContratoHonorarioAdvocaticioPJFilter();
		contratosPessoaJurídicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		contratosPessoaJurídicaFiltrados = contratoHonorarioAdvocaticiosPJ.filtrados(filtro);
	}
	
	public ContratoHonorarioAdvocaticioPJFilter getFiltro() {
		return filtro;
	}
	
	public List<ContratoHonorarioAdvocaticioPJ> getContratosPessoaJurídicaFiltrados() {
		return contratosPessoaJurídicaFiltrados;
	}
}
