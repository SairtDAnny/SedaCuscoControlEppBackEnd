package com.control.epp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.epp.entity.Entrada;
import com.control.epp.entity.Patrimonio;
import com.control.epp.service.EntradaService;
import com.control.epp.service.PatrimonioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/entrada")
public class EntradaController {

	
	@Autowired 
	EntradaService entService;
	
	@Autowired
	PatrimonioService patService;
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Entrada>> list(){
		return new ResponseEntity<>(entService.findAll(), HttpStatus.OK);
	}
	
	//listar patrimonio.-----------
	@GetMapping("/patrimonio/list")
	public ResponseEntity<List<Patrimonio>> listPatrimonio(){
		return new ResponseEntity<>(patService.findAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Entrada> listId(@PathVariable Long id){
		return new ResponseEntity<>(entService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Entrada> isnert(@RequestBody Entrada entrada){
		/*Patrimonio stockControl = patService.findByStock();
		Entrada cant = new Entrada();*/
		
		
		return new ResponseEntity<>(entService.save(entrada), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Entrada> update(@PathVariable Long id, @RequestBody Entrada entrada){
		
		Entrada entradaEncontrada = entService.findById(id);
		
		if(entradaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			entradaEncontrada.setCantidadEntrada(entrada.getCantidadEntrada());
			entradaEncontrada.setFechaEntrada(entrada.getFechaEntrada());
			entradaEncontrada.setPatrimonioEntrada(entrada.getPatrimonioEntrada());
			
			return new ResponseEntity<>(entService.save(entradaEncontrada), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		entService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
