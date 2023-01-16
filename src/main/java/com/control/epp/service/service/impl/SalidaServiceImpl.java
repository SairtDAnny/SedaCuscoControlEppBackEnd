package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Salida;
import com.control.epp.repository.SalidaRepository;
import com.control.epp.service.SalidaService;

@Service
public class SalidaServiceImpl implements SalidaService{

	@Autowired
	private SalidaRepository salRepository;
	
	
	@Override
	public List<Salida> findByColaborador(String dni) {
		return salRepository.listDni(dni);
	}
	
	@Override
	public Salida save(Salida salida) {
		return salRepository.save(salida);
	}

	@Override
	public Salida findById(Long id) {
		return salRepository.findById(id).orElse(null);
	}

	@Override
	public List<Salida> findAll() {
		return salRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		salRepository.deleteById(id);
		
	}

	@Override
	public List<Salida> listDni(String dniColaborador) throws Exception{
		try {
			List<Salida> colabo = salRepository.listDni(dniColaborador);
			return colabo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
