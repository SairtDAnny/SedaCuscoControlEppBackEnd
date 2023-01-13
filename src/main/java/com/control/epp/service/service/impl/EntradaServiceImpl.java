package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Entrada;
import com.control.epp.repository.EntradaRepository;
import com.control.epp.service.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entRepository;

	@Override
	public Entrada save(Entrada entrada) {
		return entRepository.save(entrada);
	}

	@Override
	public Entrada findById(Long id) {
		return entRepository.findById(id).orElse(null);
	}

	@Override
	public List<Entrada> findAll() {
		return entRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		entRepository.deleteById(id);
		
	}
	
	
	
}
