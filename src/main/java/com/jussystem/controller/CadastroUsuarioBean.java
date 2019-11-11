package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.jussystem.model.Grupo;
import com.jussystem.model.StatusUsuario;
import com.jussystem.model.Usuario;
import com.jussystem.repository.Grupos;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroUsuarioService;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	
	private DualListModel<Grupo> listaGrupos;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	@Inject
	private Grupos grupos;
	
	
	public void inicializar() {
		if(usuario == null) {
			limpar();
		}else {
			List<Grupo> lista = grupos.todosGrupos();
			lista.removeAll(usuario.getGrupos());
			
			listaGrupos = new DualListModel<>(lista, new ArrayList<>(usuario.getGrupos()));
		}
	}
	
	public void salvar() {
		try {
			
			if(usuario.getSenha().equals(usuario.getConfirmaSenha())) {
				usuario.setGrupos(listaGrupos.getTarget());
				usuario.setStatusUsuario(StatusUsuario.ATIVO);
				usuario = cadastroUsuarioService.salvar(usuario);
				
				FacesUtil.addInfoMessage("Usuário " + usuario.getNome()
						+", salvo com sucesso!");
				limpar();
			}else {
				FacesUtil.addInfoMessage("O campo Senha e Confirma Senha devem ser iguais!");
			}
			
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		
	}
	
	private void limpar() {
		usuario = new Usuario();
		
	
		listaGrupos = new DualListModel<>(grupos.todosGrupos(), new ArrayList<>());
	}
	

	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public DualListModel<Grupo> getListaGrupos() {
		return listaGrupos;
	}
	
	public void setListaGrupos(DualListModel<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	
	public boolean isEditando(){
		return usuario.getId() != null;
	}
	
	
	
}
