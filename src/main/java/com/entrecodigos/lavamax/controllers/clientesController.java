package com.entrecodigos.lavamax.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrecodigos.lavamax.models.cliente;
import com.entrecodigos.lavamax.service.clientesService;

@RestController
@RequestMapping("/api")
public class clientesController {
	@Autowired
	private clientesService obj;
	
	
	@GetMapping("/clientes")
	public List<cliente> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/clientes/{identificador}")
	public cliente get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/clientes")
	public cliente insertar(@RequestBody cliente obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/clientes")
	public cliente actualizar(@RequestBody cliente obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/clientes/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
}
