package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cargo;
import com.jussystem.model.Cidade;
import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.model.EstadoCivilCliente;
import com.jussystem.model.UfRgCliente;
import com.jussystem.repository.Cargos;
import com.jussystem.repository.Cidades;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroClientePessoaJuridicaService;

@Named
@ViewScoped
public class CadastroClientePessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClientePessoaJuridica clientePessoaJuridica;
	
	@Inject
	private CadastroClientePessoaJuridicaService cadastroClientePessoaJuridicaService;
	
	@Inject
	private Cidades cidadesRepository;
	
	@Inject
	private Cargos cargosRepository;

	private List<ClientePessoaJuridica> clientesJuridicos;
	
	private Cidade cidade;
	private Cargo cargo;

	private List<Cidade> cidades;
	private List<Cargo>  cargos;
	
	public CadastroClientePessoaJuridicaBean(){
		limpar();
	}
	
	public void limpar(){
		clientePessoaJuridica = new ClientePessoaJuridica();
	}
	
	public void inicializar() {
		if (clientePessoaJuridica == null){
			limpar();
		}
		cidades = cidadesRepository.buscarCidades();
		cargos = cargosRepository.buscarCargos();
	}
	
	public void salvar(){
		if(clientePessoaJuridica.getId() == null){
			this.clientePessoaJuridica.setDataCadastro(new Date());
			salvarCliente();
		}
		else{
			salvarCliente();
		}
	}
	
	public List<Cargo> completarCargo(String descricao){
		return this.cargosRepository.porNomeCargos(descricao);
	}
	
	public void salvarCliente(){
		clientePessoaJuridica = cadastroClientePessoaJuridicaService.salvar(clientePessoaJuridica);
		FacesUtil.addInfoMessage("Cliente: " + clientePessoaJuridica.getNomeContratante()+ ", salvo com sucesso!");
		limpar();
	}
	
	
	public UfRgCliente[] getUfsRgClientes(){
		return UfRgCliente.values();
	}
	
	
	public EstadoCivilCliente[] getEstadosCivilCliente(){
		return EstadoCivilCliente.values();
	}

	public boolean isEditando() {
		return this.clientePessoaJuridica.getId() != null;
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
	
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public ClientePessoaJuridica getClientePessoaJuridica() {
		return clientePessoaJuridica;
	}

	public void setClientePessoaJuridica(ClientePessoaJuridica clientePessoaJuridica) {
		this.clientePessoaJuridica = clientePessoaJuridica;
	}

	public List<ClientePessoaJuridica> getClientesJuridicos() {
		return clientesJuridicos;
	}

	public void setClientesJuridicos(List<ClientePessoaJuridica> clientesJuridicos) {
		this.clientesJuridicos = clientesJuridicos;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

}
