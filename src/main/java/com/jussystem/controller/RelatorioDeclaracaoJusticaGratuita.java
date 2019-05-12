package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
public class RelatorioDeclaracaoJusticaGratuita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse httpServletResponse;
	
	@Inject
	private EntityManager manager;*/
	
	private Date dataInicio;
	private Date dataFim;
	
	public void emitir() {
		
	}
	
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
	
}
