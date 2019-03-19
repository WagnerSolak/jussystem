package com.jussystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;




@Entity
public class Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String email;
	private String documentoReceitaFederal;
	private String registroGeral;
	private TipoPessoa tipo;
	private Date dataNascimento;
	
	private SexoPessoa sexoPessoa;
	private StatusPessoa status;
	private List<Endereco>enderecos = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@Column(unique = true, length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@CNPJ
	@CPF
	@NotNull
	@Column(nullable = false, length = 20)
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}
	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 8)
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 9)
	public SexoPessoa getSexoPessoa() {
		return sexoPessoa;
	} 
	
	public void setSexoPessoa(SexoPessoa sexoPessoa) {
		this.sexoPessoa = sexoPessoa;
	}

	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setStatus(StatusPessoa status) {
		this.status = status;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 9)
	public StatusPessoa getStatus() {
		return status;
	}
	
	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}
	
	
	@Column(length = 12)
	public String getRegistroGeral() {
		return registroGeral;
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
	
/*	@Transient
	public boolean isSelecionouTipoFiscalFisico() {
		
	}*/
	
	
}
