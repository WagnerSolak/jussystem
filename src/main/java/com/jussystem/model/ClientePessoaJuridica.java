package com.jussystem.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.jussystem.validation.OnlyLetters;

@Entity
public class ClientePessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeContratante;
	private String cnpj;
	private String endereco;
	private String numero;
	private String bairro;
	private String cep;
	private String nomeRepresentada;
	private String rgContratante;
	private String cpfContratante;
	private String nacionalidade;

	private String email;
	private String telefoneCelular1;
	private String telefoneCelular2;
	private String observacao;
	private Date dataCadastro;

	private Cargo cargo;
	private EstadoCivilCliente estadoCivil;
	private Cidade cidade;
	private UfRgCliente ufRg;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OnlyLetters
	@NotBlank 
	@Column(nullable = false, length = 100)
	public String getNomeContratante() {
		return nomeContratante;
	}

	public void setNomeContratante(String nomeContratante) {
		this.nomeContratante = nomeContratante;
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
	@Column(nullable = false, length = 100)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@NotBlank
	@Column(nullable = false, length = 7)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@NotBlank
	@Column(nullable = false, length = 80)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotBlank
	@Column(nullable = false, length = 15)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@OnlyLetters
	@NotBlank
	@Column(nullable = false, length = 200)
	public String getNomeRepresentada() {
		return nomeRepresentada;
	}

	public void setNomeRepresentada(String nomeRepresentada) {
		this.nomeRepresentada = nomeRepresentada;
	}

	@OnlyLetters
	@NotBlank
	@Column(nullable = false, length = 20)
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@NotBlank
	@Column(nullable = false, length = 20)
	public String getRgContratante() {
		return rgContratante;
	}

	public void setRgContratante(String rgContratante) {
		this.rgContratante = rgContratante;
	}

	@CPF
	@NotBlank
	@Column(nullable = false, length = 20)
	public String getCpfContratante() {
		return cpfContratante;
	}

	public void setCpfContratante(String cpfContratante) {
		this.cpfContratante = cpfContratante;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "cargo_id")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 12)
	public EstadoCivilCliente getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilCliente estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public void setUfRg(UfRgCliente ufRg) {
		this.ufRg = ufRg;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public UfRgCliente getUfRg() {
		return ufRg;
	}

	@Email(message = "O e-mail informado é inválido!")
	@Column(unique = true, length = 100)
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
	

	@Column(columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataCadastro() {
		return dataCadastro;
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
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	@Transient
	public String getDataCadastroStr(){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}
		

	
}
