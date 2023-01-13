package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Entrada;

public interface EntradaService {
	

	//insert
	public Entrada save(Entrada entrada);
	//update
	public Entrada findById(Long id);
	//list
	public List<Entrada> findAll();
	//delete
	public void delete(Long id);
}
