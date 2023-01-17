package com.control.epp.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.epp.entity.Colaborador;
import com.control.epp.entity.Patrimonio;
import com.control.epp.entity.Salida;
import com.control.epp.repository.ColaboradorRepository;
import com.control.epp.repository.PatrimonioRepository;
import com.control.epp.repository.SalidaRepository;
import com.control.epp.service.SalidaService;

@Service
public class SalidaServiceImpl implements SalidaService{

	@Autowired
	private SalidaRepository salRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	
	@Override
	public List<Salida> findByColaborador(String dni) {
		return salRepository.listDni(dni);
	}
	
	@Override
	public Salida save(Salida salida) {
		try {

			Colaborador colaborador=colaboradorRepository.findById(salida.getColaborador().getId()).orElseThrow();
			
			Patrimonio patrimonio=patrimonioRepository.findById(salida.getPatrimonioSalida().getId()).orElseThrow();
			patrimonio.setStock(patrimonio.getStock()-salida.getCantidad());
			
			Salida newRegistro = new Salida();
			newRegistro.setColaborador(colaborador);
			newRegistro.setFecha(salida.getFecha());
			newRegistro.setFechaSReno(salida.getFechaSReno());
			newRegistro.setFechaTReno(salida.getFechaTReno());
			newRegistro.setCantidad(salida.getCantidad());
			newRegistro.setTipo(salida.getTipo());
			newRegistro.setPatrimonioSalida(patrimonio);
			
			return salRepository.save(newRegistro);
			
			 
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public Salida renovacion(Long salidaId, Salida salida) {
		try {
		Salida renovacionSalida=salRepository.findById(salidaId).orElseThrow();
		
		Patrimonio patrimonio=patrimonioRepository.findById(salida.getPatrimonioSalida().getId()).orElseThrow();
		patrimonio.setStock(patrimonio.getStock()-salida.getCantidad());
		
		renovacionSalida.setCantidad(salida.getCantidad()+renovacionSalida.getCantidad());
		
		renovacionSalida.setColaborador(salida.getColaborador());
		renovacionSalida.setPatrimonioSalida(salida.getPatrimonioSalida());
		renovacionSalida.setFecha(salida.getFecha());
		renovacionSalida.setFechaSReno(salida.getFechaSReno());
		renovacionSalida.setFechaTReno(salida.getFechaTReno());
		renovacionSalida.setTipo(salida.getTipo());
		
		return salRepository.save(renovacionSalida);
		
		 
	} catch (Exception e) {
		throw new RuntimeException(e.getMessage());
	}
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

	@Override
	public List<Salida> listDni(String dniColaborador) throws Exception{
		try {
			List<Salida> colabo = salRepository.listDni(dniColaborador);
			return colabo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
