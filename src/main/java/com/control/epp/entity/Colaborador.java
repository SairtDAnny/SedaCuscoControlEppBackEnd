package com.control.epp.entity;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "colaborador")
public class Colaborador {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombreColaborador", length = 50, nullable = false)
	private String nombreColaborador;
	
	@Column(name = "apellidoColaborador", length = 80, nullable = false)
	private String apellidoColaborador;
	
	@Column(name = "dniColaborador", length = 8, nullable = false)
	private String dniColaborador;
	
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
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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


	public String getDniColaborador() {
		return dniColaborador;
	}


	public void setDniColaborador(String dniColaborador) {
		this.dniColaborador = dniColaborador;
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
		
}
