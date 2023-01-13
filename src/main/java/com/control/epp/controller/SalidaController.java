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

import com.control.epp.entity.Colaborador;
import com.control.epp.entity.Patrimonio;
import com.control.epp.entity.Salida;
import com.control.epp.service.ColaboradorService;
import com.control.epp.service.PatrimonioService;
import com.control.epp.service.SalidaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/salida")
public class SalidaController {

	@Autowired
	private SalidaService salService;
	
	@Autowired
	private PatrimonioService patseService;
	
	@Autowired
	private ColaboradorService colService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Salida>> list(){
		return new ResponseEntity<>(salService.findAll(), HttpStatus.OK);
	}
	
	//listar colaborador.-----------
	@GetMapping("/colaboradorSalida")
	public ResponseEntity<List<Colaborador>> listColaborador(){
		return new ResponseEntity<>(colService.findAll(), HttpStatus.OK);
	}
		
	//listar patrimonio.-----------
	@GetMapping("/oficinaSalida")
	public ResponseEntity<List<Patrimonio>> listPatrimonio(){
		return new ResponseEntity<>(patseService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Salida> isnert(@RequestBody Salida salida){
		return new ResponseEntity<>(salService.save(salida), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Salida> update(Long id, @RequestBody Salida salida){
		
		Salida salidaEncontrada = salService.findById(id);
		
		if(salidaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try {
			
			salidaEncontrada.setFecha(salida.getFecha());
			salidaEncontrada.setCantidad(salida.getCantidad());
			salidaEncontrada.setTipo(salida.getTipo());
			salidaEncontrada.setPatrimonioSalida(salida.getPatrimonioSalida());
			salidaEncontrada.setColaborador(salida.getColaborador());
			
			return new ResponseEntity<>(salService.save(salidaEncontrada), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		salService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
}
