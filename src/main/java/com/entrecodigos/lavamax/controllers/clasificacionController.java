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

import com.entrecodigos.lavamax.models.clasificacion;
import com.entrecodigos.lavamax.service.clasificacionService;

@RestController
@RequestMapping("/api")
public class clasificacionController {

	@Autowired
	private clasificacionService obj;
	
	@GetMapping("/clasificacion")
	public List<clasificacion> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/clasificacion/{identificador}")
	public clasificacion get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/clasificacion")
	public clasificacion insertar(@RequestBody clasificacion obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/clasificacion")
	public clasificacion actualizar(@RequestBody clasificacion obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/clasificacion/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}

	
}
