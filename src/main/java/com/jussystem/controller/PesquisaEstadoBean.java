package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;
import com.jussystem.repository.filter.EstadoFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class PesquisaEstadoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estados estados;
	
	private EstadoFilter filtro;
	private Estado estadoSelecionado;
	private List<Estado> estadosFiltrados;
	
	
	public PesquisaEstadoBean() {
		filtro = new EstadoFilter();
	}
	 
	public void pesquisar() {
		estadosFiltrados = estados.filtrados(filtro);
	}
	
	public void excluir() {
		try {
		estados.remover(estadoSelecionado);
		estadosFiltrados.remove(estadoSelecionado);
		
		FacesUtil.addInfoMessage("Estado" + estadoSelecionado.getNome()
				+ "excluído om sucesso!");
		}catch(NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public EstadoFilter getFiltro() {
		return filtro;
	}
	
	public List<Estado> getEstadosFiltrados() {
		return estadosFiltrados;
	}
	
	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}
	
	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
}
