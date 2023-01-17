package com.control.epp.entity;

import java.sql.Date;
import java.time.LocalDate;

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
	private LocalDate fecha;
	
	@Column(name = "fechaSReno", nullable = true)
	private LocalDate fechaSReno;
	
	@Column(name = "fechaTReno", nullable = true)
	private LocalDate fechaTReno;
		
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getFechaSReno() {
		return fechaSReno;
	}

	public void setFechaSReno(LocalDate fechaSReno) {
		this.fechaSReno = fechaSReno;
	}

	public LocalDate getFechaTReno() {
		return fechaTReno;
	}

	public void setFechaTReno(LocalDate fechaTReno) {
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
