package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Oficina;
import com.control.epp.repository.OficinaRepository;
import com.control.epp.service.OficinaService;

@Service
public class OficinaServiceImpl  implements OficinaService{

	@Autowired
	private OficinaRepository oficinaRepository;
	
	@Override
	public Oficina save(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	@Override
	public Oficina findById(Long id) {
		return oficinaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Oficina> findAll() {
		return oficinaRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		oficinaRepository.deleteById(id);
		
	}

}
