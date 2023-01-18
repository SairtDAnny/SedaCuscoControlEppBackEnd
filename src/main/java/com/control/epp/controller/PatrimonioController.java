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

import com.control.epp.entity.Patrimonio;
import com.control.epp.service.PatrimonioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController {

	@Autowired
	private PatrimonioService patService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Patrimonio>> list(){
		return new ResponseEntity<>(patService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patrimonio> listDni(@PathVariable Long id){
		return new ResponseEntity<>(patService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Patrimonio> insert (@RequestBody Patrimonio patrimonio){
		return new ResponseEntity<>(patService.save(patrimonio), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update")
	public ResponseEntity<Patrimonio> update(Long id, @RequestBody Patrimonio patrimonio){
		
		Patrimonio patEncontrado = patService.findById(id);
		
		if(patEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			patEncontrado.setDesPatrimonio(patrimonio.getDesPatrimonio());
			patEncontrado.setUmPatrimonio(patrimonio.getUmPatrimonio());
			patEncontrado.setStock(patrimonio.getStock());
			patEncontrado.setRetornoPatrimonio(patrimonio.getRetornoPatrimonio());
			
			return new ResponseEntity<>(patService.save(patEncontrado), HttpStatus.CREATED);
			
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		patService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
