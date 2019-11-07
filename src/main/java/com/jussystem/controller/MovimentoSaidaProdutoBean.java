package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.Produto;
import com.jussystem.model.StatusMovimentoSaidaProduto;
import com.jussystem.model.Usuario;
import com.jussystem.repository.MotivoSaidaProdutos;
import com.jussystem.repository.Produtos;
import com.jussystem.repository.Usuarios;
import com.jussystem.security.Seguranca;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroMovimentoSaidaProdutoService;


@Named
@ViewScoped
public class MovimentoSaidaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MovimentoSaidaProduto movimentoSaidaProduto;

	private Boolean exibePainelDados;
	
	@Inject
	private Usuarios usuarios;

	@Inject
	private Produtos produtos;
	
	private Produto produto;
	
	
	private Seguranca seguranca;
	
	@Inject
	private CadastroMovimentoSaidaProdutoService movimentoSaidaProdutoService;
	
	@Inject
	private MotivoSaidaProdutos motivoSaidaProdutos;
	
	private List<MotivoSaidaProduto> motivosSaidaProduto;
	private List<Usuario>usuariosListagem;
	
	
	public MovimentoSaidaProdutoBean() {
		limpar();

	}
	
	public void buscar(){
		try {
			Produto resultado = produtos.porId(produto.getId());
			
			if(resultado == null){
				exibePainelDados = false;
				FacesUtil.addInfoMessage("Não existe produto cadastrado no sistema com este código!");
			}else{
				exibePainelDados = true;
				produto = resultado;
				
			}
		} catch (RuntimeException e) {
			FacesUtil.addErrorMessage("Ocorreu um erro ao tentar buscar o produto!" + e.getMessage());
		}
	}
	
	public void inicializar() {
		if (movimentoSaidaProduto == null) {
			limpar();
			
		}
		motivosSaidaProduto = motivoSaidaProdutos.buscarMotivos();
		usuariosListagem = usuarios.buscarUsuarios();
		
	}
	
	
	public void salvarMovimentoSaida(){
		
		try {
			movimentoSaidaProduto.setDataSaida(new Date());
			movimentoSaidaProduto.setProduto(produto);
			movimentoSaidaProduto.setQuantidadeAntiga(produto.getEstoque());
			movimentoSaidaProduto.setStatusMovimentoSaidaProduto(StatusMovimentoSaidaProduto.ATIVO);
			
			
			movimentoSaidaProdutoService.recalcularNovoEstoque(movimentoSaidaProduto);

			FacesUtil.addInfoMessage("Movimento do produto: " + movimentoSaidaProduto.getProduto().getNome()
					+ ", salvo com sucesso!");
			
			exibePainelDados = false;
			movimentoSaidaProduto.setId(null);
		} catch (Exception e) {
			
			FacesUtil.addErrorMessage("Quantidade de saída maior que o estoque, verifique! ");
			e.getMessage();
		}
		
	}
	
	public void limpar(){
		movimentoSaidaProduto = new MovimentoSaidaProduto();
		produto = new Produto();
		exibePainelDados = false;
		movimentoSaidaProduto.setStatusMovimentoSaidaProduto(StatusMovimentoSaidaProduto.ATIVO);
	}
	
	public Date getMostrarDataAtual(){
		return new Date();
	}

	public List<MotivoSaidaProduto> getMotivosSaidaProduto() {
		return motivosSaidaProduto;
	}
	
	public List<Usuario> getUsuariosListagem() {
		return usuariosListagem;
	}
	
	public void setMovimentoSaidaProduto(
			MovimentoSaidaProduto movimentoSaidaProduto) {
		this.movimentoSaidaProduto = movimentoSaidaProduto;
	}
	
	public MovimentoSaidaProduto getMovimentoSaidaProduto() {
		return movimentoSaidaProduto;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Boolean getExibePainelDados() {
		return exibePainelDados;
	}
	
	public void setExibePainelDados(Boolean exibePainelDados) {
		this.exibePainelDados = exibePainelDados;
	}
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}
}
