package com.control.epp.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "colaborador")
public class Colaborador {

	@Id
	@Column(name = "id", length = 8, nullable = false)
	private String id;
	
	@Column(name = "nombreColaborador", length = 50, nullable = false)
	private String nombreColaborador;
	
	@Column(name = "apellidoColaborador", length = 80, nullable = false)
	private String apellidoColaborador;
	
	
	@Column(name = "cargoColaborador", length = 50, nullable = false)
	private String cargoColaborador;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "oficinaId")
	private Oficina oficina;


	//contructor
	public Colaborador() {
		super();
	}

	//getter and setter

	public String getNombreColaborador() {
		return nombreColaborador;
	}


	public void setNombreColaborador(String nombreColaborador) {
		this.nombreColaborador = nombreColaborador;
	}


	public String getApellidoColaborador() {
		return apellidoColaborador;
	}


	public void setApellidoColaborador(String apellidoColaborador) {
		this.apellidoColaborador = apellidoColaborador;
	}


	public String getCargoColaborador() {
		return cargoColaborador;
	}


	public void setCargoColaborador(String cargoColaborador) {
		this.cargoColaborador = cargoColaborador;
	}


	public Oficina getOficina() {
		return oficina;
	}


	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
		
}
