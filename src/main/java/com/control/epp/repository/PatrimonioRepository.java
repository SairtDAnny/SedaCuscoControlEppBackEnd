package com.control.epp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.epp.entity.Patrimonio;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
	
	Patrimonio findByStock();
}
