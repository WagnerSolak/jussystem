package com.jussystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import com.jussystem.validation.NumbersAndCharacters;



@Entity
public class Fornecedor implements Serializable {

private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nomeFantasia;
	private String razao;
	private String inscricao;
	private String cnpj;
	private String endereco;
	private String numero;
	private String bairro;
	private String complemento;
	private String cep;
	
	private String email;
	private String telefoneCelular1;
	private String telefoneCelular2;
	private String observacao;
	
	private Cidade cidade;
	private StatusFornecedor status;


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank 
	@Column(nullable=false, length = 80)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(length = 80)
	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	//@NumbersAndCharacters
	@Column(length = 18)
	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	@CNPJ
	@NotBlank
	@Column(nullable = false, length = 20)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@NotBlank
	@Column(nullable=false, length = 80)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	@NotBlank
	@Column(nullable=false, length = 80)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotBlank
	@Column(nullable=false, length = 8)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(length = 100)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(length = 10)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Email(message = "O e-mail informado é inválido!")
	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 20)
	public String getTelefoneCelular1() {
		return telefoneCelular1;
	}
	
	public void setTelefoneCelular1(String telefoneCelular1) {
		this.telefoneCelular1 = telefoneCelular1;
	}

	@Column(length = 20)
	public String getTelefoneCelular2() {
		return telefoneCelular2;
	}
	
	public void setTelefoneCelular2(String telefoneCelular2) {
		this.telefoneCelular2 = telefoneCelular2;
	}

	public void setStatus(StatusFornecedor status) {
		this.status = status;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 9)
	public StatusFornecedor getStatus() {
		return status;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Column(length = 255)
	public String getObservacao() {
		return observacao;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Transient
	public boolean isExistente(){
		return !isNovo();
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
	
	/*@Transient
	public String getStatusFormatado(){
		
		String statusFormatado = null;
		
		if(status == 'ATIVO'){
			statusFormatado = "Ativo";
		}
		if(status == 'INATIVO'){
			statusFormatado = "Inativo";
		}
		return statusFormatado;
	}*/
	
	@Transient
	public boolean isAtivo(){
		return StatusFornecedor.ATIVO.equals(this.getStatus());
	}
}
