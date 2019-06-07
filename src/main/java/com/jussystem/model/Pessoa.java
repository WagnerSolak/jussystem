package com.jussystem.model;

import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.jussystem.controller.model.validation.FisicaGroups;
import com.jussystem.controller.model.validation.JuridicaGroups;




@Entity
public class Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nomePessoa;
	private String nacionalidade;
	private String profissao;
	private String rg;
	private String documentoReceitaFederal;
	private String ctps;
	private String serieCtps;
	private Date dataNascimento;
	private Integer idade;
	private String nomeMae;
	private String endereco;
	private String numero;
	private String bairro;
	private String cep;
	private String emailPessoa;
	
	private Cidade cidade;
    private List<Contato>contatos = new ArrayList<>();
	
	private StatusPessoa status;
	
	private String observacao;
	private TipoPessoa tipo;
	private EstadoCivilPessoa estadoCivil;
	private UfRgPessoa ufRg;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	@Column(nullable = false, length = 30)
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@NotNull
	@Column(nullable = false, length = 20)
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	@CNPJ(groups = JuridicaGroups.class)
	@CPF(groups = FisicaGroups.class)
	@NotNull
	@Column(nullable = false, length = 20)
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}
	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}
	
	@NotNull
	@Column(nullable = false, length = 10)
	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	@NotNull
	@Column(nullable = false, length = 8)
	public String getSerieCtps() {
		return serieCtps;
	}
	
	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}
	
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {   
		return dataNascimento;
	}
	
	/*@Transient
	public String getDataNascimentoStr(){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
	}*/
	
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@NotNull
	@Column(nullable = false, length = 3)
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
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@NotNull
	@Column(nullable = false, length = 7)
	public String getNumero() {
		return numero;
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
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "cidade_id")
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
	
	public void setUfRg(UfRgPessoa ufRg) {
		this.ufRg = ufRg;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public UfRgPessoa getUfRg() {
		return ufRg;
	}
	
	public void setEstadoCivil(EstadoCivilPessoa estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 12)
	public EstadoCivilPessoa getEstadoCivil() {
		return estadoCivil;
	}
	
	/*@Transient
	public String getEstadoCivilFormatado(){
	
		String estadoFormatado = null;
		
		if(estadoCivil == 'SOLTEIRO'){
			estadoFormatado = "Solteiro";
		}
		
		if(estadoCivil == 'CASADO'){
			estadoFormatado = "Casado";
		}
		
		if(estadoCivil == 'SEPARADO'){
			estadoFormatado = "Separado";
		}
		
		if(estadoCivil == 'DIVORCIADO'){
			estadoFormatado = "Divorciado";
		}
		
		if(estadoCivilPessoa == 'VIUVO'){
			estadoFormatado = "Viúvo";
		}
		return estadoFormatado;
		
	}*/
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 9)
	public StatusPessoa getStatus() {
		return status;
	}
	
	public void setStatus(StatusPessoa status) {
		this.status = status;
	}
	
	
	@Column(length = 100)
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 8)
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}
	
	@Column(nullable = false, length = 80)
	public String getEmailPessoa() {
		return emailPessoa;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

	
}
