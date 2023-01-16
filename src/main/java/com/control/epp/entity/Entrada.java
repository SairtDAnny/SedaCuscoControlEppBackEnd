package com.control.epp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Entrada_Patrimonio")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidadEntrada", nullable = false)
	private Integer cantidadEntrada;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechaEntrada", nullable = false)
	private Date fechaEntrada;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "patrimonioId")
	private Patrimonio patrimonioEntrada;

	
	
	public Entrada(Long id, Integer cantidadEntrada, Date fechaEntrada, Patrimonio patrimonioEntrada) {
		super();
		this.id = id;
		this.cantidadEntrada = cantidadEntrada;
		this.fechaEntrada = fechaEntrada;
		this.patrimonioEntrada = patrimonioEntrada;
	}


	//constructor
	public Entrada() {
		super();
	}
	

	//Getter and Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidadEntrada() {
		return cantidadEntrada;
	}

	public void setCantidadEntrada(Integer cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Patrimonio getPatrimonioEntrada() {
		return patrimonioEntrada;
	}

	public void setPatrimonioEntrada(Patrimonio patrimonioEntrada) {
		this.patrimonioEntrada = patrimonioEntrada;
	}

	
}
