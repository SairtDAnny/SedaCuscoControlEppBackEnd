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

}
