package com.control.epp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	
	/*@GetMapping("/dni/{dni}")
	public ResponseEntity<Colaborador> listD(@PathVariable String dni){
		return new ResponseEntity<>(colService.findByDniColaborador(dni), HttpStatus.OK);
	}*/
	
	//listar oficin.-----------
	@GetMapping("/oficina/list")
	public ResponseEntity<List<Oficina>> listArea(){
		return new ResponseEntity<>(oficinaService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Colaborador> insert(@RequestBody Colaborador colaborador){
		
		return new ResponseEntity<>(colService.save(colaborador), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Colaborador> update(@PathVariable String id,@RequestBody Colaborador colaborador){
		System.out.println("LLAMA A LA FUNCION  ");
		
		Colaborador colaboradorEncontrado = colService.findById(id);
		
		if(colaboradorEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("esta bien ");
		try {
			System.out.println("esta bien al try ");
			
			colaboradorEncontrado.setId(colaborador.getId());
			colaboradorEncontrado.setNombreColaborador(colaborador.getNombreColaborador());
			colaboradorEncontrado.setApellidoColaborador(colaborador.getApellidoColaborador());
			colaboradorEncontrado.setCargoColaborador(colaborador.getCargoColaborador());
			colaboradorEncontrado.setOficina(colaborador.getOficina());
			System.out.println("guarad los datos en espera ");
			return new ResponseEntity<>(colService.save(colaboradorEncontrado),HttpStatus.CREATED);
			
		} catch (DataAccessException e) {
			System.out.println(" NO guarada los archisdcos ");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String  id){
		colService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
