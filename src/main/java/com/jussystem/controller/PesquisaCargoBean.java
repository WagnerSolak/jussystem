package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cargo;
import com.jussystem.repository.Cargos;
import com.jussystem.repository.filter.CargoFilter;

@Named
@ViewScoped
public class PesquisaCargoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cargos cargos;
	
	private CargoFilter filtro;
	
	private List<Cargo> cargoFiltrados;
	
	
	
	public PesquisaCargoBean(){
		filtro = new CargoFilter();
	}
	
	public void pesquisar(){
		cargoFiltrados = cargos.filtradas(filtro);
	}
	
	
	public List<Cargo> getCargoFiltrados() {
		return cargoFiltrados;
	}
	
	public CargoFilter getFiltro() {
		return filtro;
	}
}
