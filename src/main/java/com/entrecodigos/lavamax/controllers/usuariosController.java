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

import com.entrecodigos.lavamax.models.usuario;
import com.entrecodigos.lavamax.service.usuariosService;

@RestController
@RequestMapping("/api")
public class usuariosController {

	@Autowired
	private usuariosService obj;
	
	
	@GetMapping("/usuarios")
	public List<usuario> getAll(@RequestParam(name = "id_sucursal",defaultValue = "",required = false) String id_sucursal){
		if(!id_sucursal.equals("")) {
			return obj.getAll(Long.parseLong(id_sucursal));
		}else {
			return obj.getAll();
		}
	}
	
	
	@PostMapping("/usuarios")
	public usuario insertar(@RequestBody usuario obj) {
		return  this.obj.insertar(obj);
	}
	
	
	@PutMapping("/usuarios")
	public usuario actualizar(@RequestBody usuario obj) {
		return  this.obj.actualizar(obj);
	}
	
	
	@DeleteMapping("/usuarios/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return  this.obj.eliminar(id);
	}
	
	
	@PostMapping("/ingresar")
	public usuario ingresar(@RequestBody usuario obj) throws Throwable {
		return  this.obj.ingresar(obj);
		
	}
	
	
	@GetMapping("/usuarios/{id}/{password}/{nuevo}")
	public boolean usuarioGetUsuario(@PathVariable("id")Long id,@PathVariable("password") String pass,@PathVariable("nuevo")String nuevo) {
		
		return this.obj.getUsuarioPassword(id, pass,nuevo);
	}
	
	
	
}
