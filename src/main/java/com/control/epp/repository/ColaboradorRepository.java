package com.control.epp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.epp.entity.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	public Colaborador findOneByDniColaborador(String dni);
	public Colaborador findByDniColaborador(String dni);
}
