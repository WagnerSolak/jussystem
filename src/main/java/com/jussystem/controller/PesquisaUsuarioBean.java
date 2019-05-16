package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jussystem.repository.filter.UsuarioFilter;
import com.jussystem.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
    private Usuario usuarioSelecionado;
	
	private List<Usuario>usuariosFiltrados;
	
	private UsuarioFilter filtro;
	
	

	public PesquisaUsuarioBean() {
		filtro = new UsuarioFilter();
	}
	
	public void excluir() {
		
		usuarios.remover(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
		
		FacesUtil.addInfoMessage("Usuario EXCLUIDO com sucesso!");
		System.out.println("Exclui com sucesso");
	}
	
	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
		//this.refresh();
	}
	
	/*public void refresh() {                           Tentativa de dar um refresh e arrumar problema
        FacesContext context = FacesContext.getCurrentInstance();  
        Application application = context.getApplication();  
        ViewHandler viewHandler = application.getViewHandler();  
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
        context.setViewRoot(viewRoot);  
        context.renderResponse();  
    } */
	
	
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
	
	public UsuarioFilter getFiltro() {
		return filtro;
	}
	
}
