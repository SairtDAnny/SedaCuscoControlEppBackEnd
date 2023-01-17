package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Entrada;
import com.control.epp.entity.Patrimonio;
import com.control.epp.repository.EntradaRepository;
import com.control.epp.repository.PatrimonioRepository;
import com.control.epp.service.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entRepository;
	@Autowired
	private PatrimonioRepository patrimonioRepository;

	@Override
	public Entrada save( Entrada entrada) {
		try {
			Patrimonio patrimonio=patrimonioRepository.findById(entrada.getPatrimonioEntrada().getId()).orElseThrow();
			patrimonio.setStock(patrimonio.getStock()+entrada.getCantidadEntrada());
			
			entrada.setPatrimonioEntrada(patrimonio);
			
			return entRepository.save(entrada);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
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
