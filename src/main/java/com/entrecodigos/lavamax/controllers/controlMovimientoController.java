package com.entrecodigos.lavamax.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.models.proveedores;
import com.entrecodigos.lavamax.service.controlMovimientoService;


@RestController
@RequestMapping("/api")

public class controlMovimientoController {
	
	@Autowired
	private controlMovimientoService obj;
	
	@PostMapping("/inventario")
	public controlMovimiento insertar(@RequestBody controlMovimiento obj) {
		return this.obj.insertar(obj);
	}
	

	@PostMapping("/inventario/movimientos")
	public void   insertarAll(@RequestBody List <controlMovimiento> obj) {
		 this.obj.insertarlista(obj);
	}
	
	@GetMapping("/inventario/corteinicial/{sucursal}/{id_usuario}")
	public Object CorteInv(@PathVariable ("sucursal") Integer sucursal , @PathVariable ("id_usuario") Integer id_usuario  ) {
		return obj.CorteInv(sucursal, id_usuario);
}
	

}
