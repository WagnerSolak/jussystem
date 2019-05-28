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

@Entity
public class InativaPessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String usuarioLogado;
	private String motivoInativacao;
	private Date dataHoraInativacao;
	private Pessoa pessoa;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 80)
	public String getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	@Column(nullable = false, length = 50)
	public String getMotivoInativacao() {
		return motivoInativacao;
	}
	public void setMotivoInativacao(String motivoInativacao) {
		this.motivoInativacao = motivoInativacao;
	}
	
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataHoraInativacao() {
		return dataHoraInativacao;
	}
	public void setDataHoraInativacao(Date dataHoraInativacao) {
		this.dataHoraInativacao = dataHoraInativacao;
	}
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id",nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		InativaPessoa other = (InativaPessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
