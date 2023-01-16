package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Salida;

public interface SalidaService {
	//por  DNI
	
	public List<Salida> findByColaborador(String dni);
	//public Colaborador findByDniColaborador(String dni);
	public List<?> listDni(String dniColaborador) throws Exception;
	
	//insert
	public Salida save(Salida salida);
	//update
	public Salida findById(Long id);
	//list
	public List<Salida> findAll();
	//delete
	public void delete(Long id);
}
