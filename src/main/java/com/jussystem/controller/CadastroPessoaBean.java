/*package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jussystem.model.Cidade;
import com.jussystem.model.Contato;
import com.jussystem.model.Estado;
import com.jussystem.model.EstadoCivilPessoa;
import com.jussystem.model.Pessoa;
import com.jussystem.model.StatusPessoa;
import com.jussystem.model.TipoPessoa;
import com.jussystem.model.UfRgCliente;
import com.jussystem.repository.Cidades;
import com.jussystem.repository.Estados;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroPessoaService;
import com.jusystem.service.NegocioException;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	private Estado estado;
	private Cidade cidade;

	private Contato contato;

	private List<Cidade> cidades;
	private List<Estado> estados;

	private boolean editandoContato;

	@Inject
	private CadastroPessoaService cadastroPessoaService;

	@Inject
	private Estados estadosRepository;

	@Inject
	private Cidades cidadesRepository;

	public void inicializar() {
		if (pessoa == null) {
			limpar();

		}
		estados = estadosRepository.buscarEstados();

	}

	public void carregarEstados() {
		estados = estadosRepository.buscarEstados();
	}

	public void carregarCidades() {
		cidades = cidadesRepository.buscarCidades();
	}

	public void salvar() {
		try {
			pessoa.setStatus(StatusPessoa.ATIVO);
			pessoa = cadastroPessoaService.salvar(pessoa);
			limpar();
			FacesUtil.addInfoMessage("Pessoa salva com sucesso!");

		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public void novoContato() {
		this.contato = new Contato();
		this.contato.setPessoa(this.pessoa);
		this.editandoContato = false;
	}

	public void editarContato(Contato contato) {
		this.contato = contato;
		this.editandoContato = true;
	}

	public void excluirContato(Contato contato) {
		this.pessoa.getContatos().remove(contato);
	}

	public void limpar() {
		this.pessoa = new Pessoa();
		cidades = new ArrayList<Cidade>();

		this.pessoa.setTipo(TipoPessoa.FISICA);

	}

	public EstadoCivilPessoa[] getEstadosCivilPessoa() {
		return EstadoCivilPessoa.values();
	}

	public UfRgCliente[] getUfsRgPessoa() {
		return UfRgCliente.values();
	}

	public void popularCidadePorEstado() {
		try {
			if (estado != null) {
				cidades = cidadesRepository.buscarCidadePorEstado(estado.getId());

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro ao listar Cidades!");
		}

	}

	public Date getDataHoje() {
		return new Date();
	}

	public void confirmarContato() {
		if (!this.pessoa.getContatos().contains(this.contato)) {
			this.pessoa.getContatos().add(this.contato);
		}
	}

	public boolean isEditando() {
		return pessoa != null && pessoa.getId() != null;
	}

	public boolean isEditandoContato() {
		return editandoContato;
	}

	public TipoPessoa[] getTipos() {
		return TipoPessoa.values();
	}

	public StatusPessoa[] getStatus() {
		return StatusPessoa.values();
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;

	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;

	}

	public Cidade getCidade() {
		return cidade;

	}

}
*/