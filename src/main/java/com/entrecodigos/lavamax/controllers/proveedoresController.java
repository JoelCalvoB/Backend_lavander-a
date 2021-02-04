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

import com.entrecodigos.lavamax.models.proveedores;
import com.entrecodigos.lavamax.service.proveedoresService;

@RestController
@RequestMapping("/api")
public class proveedoresController {
	@Autowired
	private proveedoresService obj;
	
	
	@GetMapping("/proveedores")
	public List<proveedores> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/proveedores/{identificador}")
	public proveedores get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/proveedores")
	public proveedores insertar(@RequestBody proveedores obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/proveedores")
	public proveedores actualizar(@RequestBody proveedores obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/proveedores/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
}
