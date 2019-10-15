package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cidade;
import com.jussystem.model.Fornecedor;
import com.jussystem.model.StatusFornecedor;
import com.jussystem.repository.Cidades;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroFornecedorService;

@Named
@ViewScoped
public class CadastroFornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFornecedorService cadastroFornecedorService;

	@Inject
	private Cidades cidadesRepository;

	private Cidade cidade;

	private Fornecedor fornecedor;

	private List<Cidade> cidades;

	public CadastroFornecedorBean() {
		limpar();
	}
	
	public void inicializar() {
		if (fornecedor == null) {
			limpar();
		}
		cidades = cidadesRepository.buscarCidades();
	}

	public void salvar() {
		if(fornecedor.getId() == null){
			fornecedor.setStatus(StatusFornecedor.ATIVO);
			salvarFornecedor();
		}else{
			salvarFornecedor();
		}
		

	}

	public void salvarFornecedor() {
		fornecedor = cadastroFornecedorService.salvar(fornecedor);

		FacesUtil.addInfoMessage("Fornecedor: " + fornecedor.getNomeFantasia()
				+ ", salvo com sucesso!");
		limpar();
	}

	public void limpar() {
		fornecedor = new Fornecedor();
	}

	

	public boolean isEditando() {
		return this.fornecedor.getId() != null;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;

	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}
}
