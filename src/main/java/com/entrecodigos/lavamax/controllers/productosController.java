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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entrecodigos.lavamax.models.productos;
import com.entrecodigos.lavamax.service.productosService;

@RestController
@RequestMapping("/api")
public class productosController {

	@Autowired
	private productosService obj;
	
	
	@GetMapping("/productos")
	public List<productos> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/productos/{identificador}")
	public productos get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/productos")
	public productos insertar(@RequestBody productos obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/productos")
	public productos actualizar(@RequestBody productos obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/productos/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
	
	@GetMapping("/productos/paginacion")
	public List<productos> getProductosPaginado(@RequestParam int pagina){
		return this.obj.getProductosPaginado(pagina);
	}
}
