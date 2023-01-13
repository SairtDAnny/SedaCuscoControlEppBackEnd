package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Oficina;

public interface OficinaService {
	
	public Oficina save(Oficina oficina);
	
	public Oficina findById(Long id);
	
	public List<Oficina> findAll();
	
	public void delete(Long id);
}
