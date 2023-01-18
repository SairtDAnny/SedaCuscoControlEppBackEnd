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

import com.control.epp.entity.Oficina;
import com.control.epp.service.OficinaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/oficina")


public class OficinaController {

	@Autowired
	private OficinaService ofiService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Oficina>> list(){
		return new ResponseEntity<>(ofiService.findAll(),HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/insert")
	public ResponseEntity<Oficina> insert(@RequestBody Oficina oficina){
		
		return new ResponseEntity<>(ofiService.save(oficina), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<Oficina> update(@PathVariable Long id, @RequestBody Oficina oficina){
		
		Oficina oficinaEncontrada = ofiService.findById(id);
		if(oficinaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			oficinaEncontrada.setDesOficina(oficina.getDesOficina());
			
			return new ResponseEntity<>(ofiService.save(oficinaEncontrada), HttpStatus.CREATED);
			
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		ofiService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
