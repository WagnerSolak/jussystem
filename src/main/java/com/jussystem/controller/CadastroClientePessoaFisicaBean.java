package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;





import com.jussystem.model.Cidade;
import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.EstadoCivilCliente;
import com.jussystem.model.Profissao;
import com.jussystem.model.UfRgCliente;
import com.jussystem.repository.Cidades;
import com.jussystem.repository.Profissoes;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroClientePessoaFisicaService;

@Named
@ViewScoped
public class CadastroClientePessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroClientePessoaFisicaService cadastroClientePessoaFisicaService;

	private ClientePessoaFisica clientePessoaFisica;
	
	@Inject
	private Cidades cidadesRepository;
	
	@Inject
	private Profissoes profissoes;

	private List<ClientePessoaFisica> clientesFisicas;

	private Cidade cidade;

	private List<Cidade> cidades;

	public CadastroClientePessoaFisicaBean() {
		limpar();
	}

	public void limpar() {
		clientePessoaFisica = new ClientePessoaFisica();
	}

	public void inicializar() {
		if (clientePessoaFisica == null) {
			limpar();
		}
		cidades = cidadesRepository.buscarCidades();
	}
	
	public void salvar(){
		if(clientePessoaFisica.getId() == null){
			clientePessoaFisica.setDataCadastro(new Date());
			salvarCliente();
		}else{
			salvarCliente();
		}
	}
	
	public void salvarCliente(){
		clientePessoaFisica = cadastroClientePessoaFisicaService.salvar(clientePessoaFisica);
		FacesUtil.addInfoMessage("Cliente: " + clientePessoaFisica.getNomePessoa()+ ", salvo com sucesso!");
		limpar();
	}
	
	public List<Profissao> completarProfissao(String descricao){
		return this.profissoes.porNomeProfissoes(descricao);
	}
	
	public void calcularIdadeCliente(){
			if(this.clientePessoaFisica != null){
				this.clientePessoaFisica.calcularIdade();
			}
			
	}
	
	
	public UfRgCliente[] getUfsRgClientes(){
		return UfRgCliente.values();
	}
	
	public EstadoCivilCliente[] getEstadosCivilCliente(){
		return EstadoCivilCliente.values();
	}

	public boolean isEditando() {
		return this.clientePessoaFisica.getId() != null;
	}
	
	public Date getDataHoje() {
		return new Date();
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

	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}

	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
	}

	public void setClientesFisicas(List<ClientePessoaFisica> clientesFisicas) {
		this.clientesFisicas = clientesFisicas;
	}

	public List<ClientePessoaFisica> getClientesFisicas() {
		return clientesFisicas;
	}
	
	
}
