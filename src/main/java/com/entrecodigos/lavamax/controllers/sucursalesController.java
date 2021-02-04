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

import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.service.sucursalesService;

@RestController
@RequestMapping("/api")
public class sucursalesController {

	@Autowired
	private sucursalesService obj;
	
	
	@GetMapping("/sucursales")
	public List<sucursales> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/sucursales/{identificador}")
	public sucursales get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/sucursales")
	public sucursales insertar(@RequestBody sucursales obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/sucursales")
	public sucursales actualizar(@RequestBody sucursales obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/sucursales/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
}
