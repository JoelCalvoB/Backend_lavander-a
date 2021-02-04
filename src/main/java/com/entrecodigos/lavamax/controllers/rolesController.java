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

import com.entrecodigos.lavamax.models.menu;
import com.entrecodigos.lavamax.models.roles;
import com.entrecodigos.lavamax.service.rolesService;

@RestController
@RequestMapping("/api")
public class rolesController {

	@Autowired
	private rolesService obj;
	
	@GetMapping("/roles")
	public List<roles> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/roles/{identificador}")
	public roles get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/roles")
	public roles insertar(@RequestBody roles obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/roles")
	public roles actualizar(@RequestBody roles obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/roles/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
	
	
	@GetMapping("/roles/menu")
	public List<menu> obtenerMenus() {
		
		return this.obj.obtenerMenus();
	}
	
}
