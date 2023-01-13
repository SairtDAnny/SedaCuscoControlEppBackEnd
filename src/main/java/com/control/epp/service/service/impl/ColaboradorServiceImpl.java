package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Colaborador;
import com.control.epp.repository.ColaboradorRepository;
import com.control.epp.service.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{

	@Autowired
	private ColaboradorRepository colRepository;
	
	@Override
	public Colaborador save(Colaborador colaborador) {
		return colRepository.save(colaborador);
	}

	@Override
	public Colaborador findById(Long id) {
		return colRepository.findById(id).orElse(null);
	}

	@Override
	public List<Colaborador> findAll() {
		return colRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		colRepository.deleteById(id);
		
	}

	@Override
	public Colaborador findByDniColaborador(String dni) {
		return colRepository.findByDniColaborador	(dni);
	}

}
