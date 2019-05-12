package com.jussystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class ProcuracaoAdJudicia implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String rg;
	private String cpf;
	private String ctps;
	private String serie;
	private Date dataNascimento;
	private Integer idade;
	private String nomeMae;
	private String endereco;
	private String bairro;
	private String cep;
	/*private Cidade cidade;
	private Estado estado;*/
	private String nomePessoa;
	private String nacionalidade;
	private String estadoCivil;
	private String profissao;
	private String ufRg;
	private Date dataAtual;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(length = 3)
	public Integer getIdade() {
		return idade;
	}
	
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	@NotNull
	@Column(nullable = false, length = 100)
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@NotNull
	@Column(nullable = false, length = 80)
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@NotNull
	@Column(nullable = false, length = 15)
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/*@ManyToOne
	@JoinColumn(name = "cidade_id",nullable = false)
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@ManyToOne
	@JoinColumn(name = "estado_id",nullable = false)
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}*/
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	@NotNull
	@Column(nullable = false, length = 15)
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@NotNull
	@Column(nullable = false, length = 30)
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@NotNull
	@Column(nullable = false, length = 2)
	public String getUfRg() {
		return ufRg;
	}
	
	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataAtual() {
		return dataAtual;
	}
	
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcuracaoAdJudicia other = (ProcuracaoAdJudicia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
