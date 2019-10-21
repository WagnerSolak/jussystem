package com.jussystem.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



@Entity
public class MovimentoSaidaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dataSaida;
	private String observacao;
	private String usuario;
	
	private Integer quantidadeNova;

	private Produto produto;
	private MotivoSaidaProduto motivoSaida;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataSaida() {
		return dataSaida;
	}
	
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	
	@Column(nullable = false, length = 100)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(nullable = false, length = 100)
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false, name = "motivoSaidaProduto_id")
	public MotivoSaidaProduto getMotivoSaida() {
		return motivoSaida;
	}

	public void setMotivoSaida(MotivoSaidaProduto motivoSaida) {
		this.motivoSaida = motivoSaida;
	}
	
	@NotNull
	@Column(nullable = false, length = 4)
	public Integer getQuantidadeNova() {
		return quantidadeNova;
	}
	
	public void setQuantidadeNova(Integer quantidadeNova) {
		this.quantidadeNova = quantidadeNova;
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
		MovimentoSaidaProduto other = (MovimentoSaidaProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient
	public String getDataSaidaStr(){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataSaida);
	}

	
}
