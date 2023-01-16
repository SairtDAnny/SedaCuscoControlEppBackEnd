package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Colaborador;

public interface ColaboradorService {
	//buscar por dni
	//public Colaborador findByDniColaborador(String dni);
	//insert
	public Colaborador save(Colaborador colaborador);
	//update
	public Colaborador findById(String id);
	//list
	public List<Colaborador> findAll();
	//delete
	public void delete(String id);
}
