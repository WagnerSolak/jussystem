package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroMotivoSaidaProdutoService;

@Named
@ViewScoped
public class CadastroMotivoSaidaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMotivoSaidaProdutoService cadastroMotivoSaidaProdutoService;
	
	private MotivoSaidaProduto motivoSaidaProduto;
	

	
	public CadastroMotivoSaidaProdutoBean(){
		limpar();
	}
	
	public void limpar(){
		motivoSaidaProduto = new MotivoSaidaProduto();
	}
	
	public void inicializar() {
		if(motivoSaidaProduto == null){
			limpar();
		}
	}
	
	public boolean isEditando() {
		return this.motivoSaidaProduto.getId() != null;
	}
	
	public void salvar() {
		motivoSaidaProduto = cadastroMotivoSaidaProdutoService.salvar(motivoSaidaProduto);
		FacesUtil.addInfoMessage("Motivo Saída de Produto: " +motivoSaidaProduto.getMotivoSaida()
				+ ", salvo com sucesso!");
		limpar();
		
	}	
	
	public void setMotivoSaidaProduto(MotivoSaidaProduto motivoSaidaProduto) {
		this.motivoSaidaProduto = motivoSaidaProduto;
	}  
	
	public MotivoSaidaProduto getMotivoSaidaProduto() {
		return motivoSaidaProduto;
	}
	
	
	
}
