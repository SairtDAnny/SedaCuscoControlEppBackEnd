package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Salida;

public interface SalidaService {
	//insert
	public Salida save(Salida salida);
	//update
	public Salida findById(Long id);
	//list
	public List<Salida> findAll();
	//delete
	public void delete(Long id);
}
