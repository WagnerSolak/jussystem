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
import org.hibernate.validator.constraints.br.CPF;

import com.jussystem.validation.OnlyLetters;


@Entity
public class ClientePessoaFisica implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomePessoa;
	private String nacionalidade;
	private String rg;
	private String cpf;
	private String ctps;
	private String serieCtps;
	private Date dataNascimento;
	private Integer idade;
	private String nomeMae;
	private String endereco;
	private String numero;
	private String bairro;
	private String cep;
	
	private String email;  
	private String telefoneCelular1;
	private String telefoneCelular2;
	private String observacao;
	private Date dataCadastro;
	
	private UfRgCliente ufRg;
	private Cidade cidade;
	private EstadoCivilCliente estadoCivil;
	private Profissao profissao;
	
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
	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
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
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "profissao_id")
	public Profissao getProfissao() {
		return profissao;
	}
	
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	@NotBlank //@NumbersAndCharacters
	@Column(nullable = false, length = 20)
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@CPF
	@NotBlank
	@Column(nullable = false, length = 20)
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	@NotBlank
	@Column(nullable = false, length = 8)
	public String getSerieCtps() {
		return serieCtps;
	}
	
	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}
	
	@NotNull
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
		calcularIdade();
	}
	
	@NotNull
	@Column(nullable = false, length = 3)
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@OnlyLetters
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
	
	@NotBlank
	@Column(nullable = false, length = 7)
	public String getNumero() {
		return numero;
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
	
	@Column(columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public UfRgCliente getUfRg() {
		return ufRg;
	}
	
	public void setUfRg(UfRgCliente ufRg) {
		this.ufRg = ufRg;
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
		ClientePessoaFisica other = (ClientePessoaFisica) obj;
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
	
	
	
	
	@Transient
	public String getDataNascimentoStr(){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
	}

	
	@Transient
	public String getDataCadastroStr(){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}
	
	
	public void calcularIdade() {
		Date dataHoje = new Date();
		Date dataNasc = getDataNascimento();
	
			
			//Integer idade = idade + dataHoje - dataNasc;
			@SuppressWarnings("deprecation") //apenas para dar warning
			Integer anoNascimento = dataNasc.getYear();
			@SuppressWarnings("deprecation")
			Integer anoAtual = dataHoje.getYear();
			
			Integer idade = anoAtual - anoNascimento;
			setIdade(idade);
	}
}
