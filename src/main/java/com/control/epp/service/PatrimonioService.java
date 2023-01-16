package com.control.epp.service;

import java.util.List;

import com.control.epp.entity.Patrimonio;

public interface PatrimonioService {
	public Patrimonio findByStock();
	//insert
	public Patrimonio save(Patrimonio patrmonio);
	//update
	public Patrimonio findById(Long id);
	//list
	public List<Patrimonio> findAll();
	//delete
	public void delete(Long id);
}