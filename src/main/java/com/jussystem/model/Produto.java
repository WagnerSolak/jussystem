package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private BigDecimal valorUnitario;
	private Short estoque;
	
	private Categoria categoria;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@Column(nullable = false,precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@NotNull @Min(0) @Max(9999)
	@Column(nullable = false, length = 5)
	public Short getEstoque() {
		return estoque;
	}
	
	public void setEstoque(Short estoque) {
		this.estoque = estoque;
	}
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	public Categoria getCategoria() {
		return categoria;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	public void adicionarEstoque(Integer quantidade) {
		int novaQuantidade = this.getEstoque() + quantidade;

		this.setEstoque((short) novaQuantidade);
		
	}
	public void subtrairEstoque(Integer quantidade) {
		this.setEstoque((short) (getEstoque() - quantidade));
		
	}
	
	
	
	
}
