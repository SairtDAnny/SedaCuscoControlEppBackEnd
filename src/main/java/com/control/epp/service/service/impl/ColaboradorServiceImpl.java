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
	public List<Colaborador> findAll() {
		return colRepository.findAll();
	}

	@Override
	public void delete(String id) {
		colRepository.deleteById(id);
	}

	@Override
	public Colaborador findById(String id) {
		return colRepository.findById(id).orElse(null);
	}



}
