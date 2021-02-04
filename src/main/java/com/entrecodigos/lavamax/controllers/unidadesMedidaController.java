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

import com.entrecodigos.lavamax.models.unidadesMedida;
import com.entrecodigos.lavamax.service.unidadesMedidaService;

@RestController
@RequestMapping("/api")
public class unidadesMedidaController {

	@Autowired
	private unidadesMedidaService obj;
	
	@GetMapping("/umedidas")
	public List<unidadesMedida> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/umedidas/{identificador}")
	public unidadesMedida get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/umedidas")
	public unidadesMedida insertar(@RequestBody unidadesMedida obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/umedidas")
	public unidadesMedida actualizar(@RequestBody unidadesMedida obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/umedidas/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
	
}
