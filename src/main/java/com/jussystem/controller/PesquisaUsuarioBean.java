package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.StatusUsuario;
import com.jussystem.model.Usuario;
import com.jussystem.repository.Usuarios;
import com.jussystem.repository.filter.UsuarioFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroUsuarioService;


@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
    private Usuario usuarioSelecionado;
	
	private List<Usuario>usuariosFiltrados;
	
	private UsuarioFilter filtro;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	public PesquisaUsuarioBean() {
		filtro = new UsuarioFilter();
		usuariosFiltrados = new ArrayList<>();
	}
	
	
	public void pesquisar() {
		usuariosFiltrados = usuarios.filtrados(filtro);
		
	}
	
	
	public void salvarRemoverDaLista() {
		usuarioSelecionado = cadastroUsuarioService.salvar(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
	}
	
	public StatusUsuario[]getStatuses(){
		return StatusUsuario.values();
	}
	
	public void ativarDesativarStatusUsuario(){
		if(usuarioSelecionado != null){
			if(usuarioSelecionado.getStatusUsuario().equals(StatusUsuario.ATIVO)){
				usuarioSelecionado.setStatusUsuario(StatusUsuario.INATIVO);
				FacesUtil.addInfoMessage("Usuário " + usuarioSelecionado.getNome()+ ",Inativado com sucesso!");
				salvarRemoverDaLista();
			}else{
				usuarioSelecionado.setStatusUsuario(StatusUsuario.ATIVO);
				FacesUtil.addInfoMessage("Usuário " + usuarioSelecionado.getNome()+", Ativado com sucesso!");
				salvarRemoverDaLista();
			}
		}
	}
	
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
