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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "salida_patrimonio")
public class Salida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@Column(name = "fechaSReno", nullable = true)
	private Date fechaSReno;
	
	@Column(name = "fechaTReno", nullable = true)
	private Date fechaTReno;
		
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "tipo", length = 20 ,nullable = false)
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "patrimonioId")
	private Patrimonio patrimonioSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "colaboradorId")
	private Colaborador colaborador;

	//constructor
	public Salida() {
		super();
	}

	//getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaSReno() {
		return fechaSReno;
	}

	public void setFechaSReno(Date fechaSReno) {
		this.fechaSReno = fechaSReno;
	}

	public Date getFechaTReno() {
		return fechaTReno;
	}

	public void setFechaTReno(Date fechaTReno) {
		this.fechaTReno = fechaTReno;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Patrimonio getPatrimonioSalida() {
		return patrimonioSalida;
	}

	public void setPatrimonioSalida(Patrimonio patrimonioSalida) {
		this.patrimonioSalida = patrimonioSalida;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}	
}
