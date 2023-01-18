package com.control.epp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.epp.entity.Colaborador;
import com.control.epp.entity.Oficina;
import com.control.epp.service.OficinaService;
import com.control.epp.service.ColaboradorService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colService;
	
	@Autowired
	private OficinaService oficinaService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Colaborador>> list(){
		return new ResponseEntity<>(colService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> listDni(@PathVariable String id){
		return new ResponseEntity<>(colService.findById(id), HttpStatus.OK);
	}
	
	
	//listar oficin.-----------
	@GetMapping("/oficina/list")
	public ResponseEntity<List<Oficina>> listArea(){
		return new ResponseEntity<>(oficinaService.findAll(), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/insert")
	public ResponseEntity<Colaborador> insert(@RequestBody Colaborador colaborador){
		
		return new ResponseEntity<>(colService.save(colaborador), HttpStatus.CREATED);
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<Colaborador> update(@PathVariable String id,@RequestBody Colaborador colaborador){
		
		Colaborador colaboradorEncontrado = colService.findById(id);
		
		if(colaboradorEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			
			colaboradorEncontrado.setId(colaborador.getId());
			colaboradorEncontrado.setNombreColaborador(colaborador.getNombreColaborador());
			colaboradorEncontrado.setApellidoColaborador(colaborador.getApellidoColaborador());
			colaboradorEncontrado.setCargoColaborador(colaborador.getCargoColaborador());
			colaboradorEncontrado.setOficina(colaborador.getOficina());

			return new ResponseEntity<>(colService.save(colaboradorEncontrado),HttpStatus.CREATED);
			
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String  id){
		colService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
