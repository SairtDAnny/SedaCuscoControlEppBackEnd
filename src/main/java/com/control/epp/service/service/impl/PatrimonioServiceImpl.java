package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Patrimonio;
import com.control.epp.repository.PatrimonioRepository;
import com.control.epp.service.PatrimonioService;

@Service	
public class PatrimonioServiceImpl implements PatrimonioService {

	@Autowired
	private PatrimonioRepository patRepository;
	
	@Override
	public Patrimonio save(Patrimonio patrmonio) {
		return patRepository.save(patrmonio);
	}

	@Override
	public Patrimonio findById(Long id) {
		return patRepository.findById(id).orElse(null);
	}

	@Override
	public List<Patrimonio> findAll() {
		return patRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		patRepository.deleteById(id);
		
	}

	@Override
	public Patrimonio findByStock() {
		return patRepository.findByStock();
	}
	
}
