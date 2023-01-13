package com.control.epp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "patrimonio")
public class Patrimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "desPatrimonio", length = 100, nullable = false)
	private String desPatrimonio;
	
	@Column(name = "umPatrimonio", length = 20, nullable = false)
	private String umPatrimonio;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "retornoPatrimonio", nullable = false)
	private Boolean retornoPatrimonio;

	
	//constructor
	public Patrimonio() {
		super();
	}

	
	//getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesPatrimonio() {
		return desPatrimonio;
	}

	public void setDesPatrimonio(String desPatrimonio) {
		this.desPatrimonio = desPatrimonio;
	}

	public String getUmPatrimonio() {
		return umPatrimonio;
	}

	public void setUmPatrimonio(String umPatrimonio) {
		this.umPatrimonio = umPatrimonio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getRetornoPatrimonio() {
		return retornoPatrimonio;
	}

	public void setRetornoPatrimonio(Boolean retornoPatrimonio) {
		this.retornoPatrimonio = retornoPatrimonio;
	}
	
	
	
}
