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

import com.entrecodigos.lavamax.models.servicio_detalle;
import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.service.clientesService;
import com.entrecodigos.lavamax.service.servicio_detalleService;
import com.entrecodigos.lavamax.service.servicio_detalleService;
import com.entrecodigos.lavamax.service.sucursalesService;


@RestController
@RequestMapping("/api")

public class servicio_detalleController {
	

	@Autowired
	private servicio_detalleService obj;
	
	
	@GetMapping("/serviciodetalles")
	public List<servicio_detalle> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/servicio_detalles/{identificador}")
	public servicio_detalle get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	 @GetMapping("/serviciodetalles/{desde}/{hasta}/{empresa}/{tiposervicio}/{idempleado}")
	    public Object traeDetalleFichas(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta,@PathVariable("empresa")String empresa , @PathVariable ("tiposervicio") String tiposervicio , @PathVariable ("idempleado") String idempleado) {
	      return   obj.traeDetalleFichas(desde, hasta , empresa , tiposervicio , idempleado);
	    }
	 
	 
	 @GetMapping("/serviciodetalles/sumafichas/{desde}/{hasta}/{empresa}/{tiposervicio}/{idempleado}")
	    public Object SumaFichas(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta,@PathVariable("empresa")String empresa , @PathVariable ("tiposervicio") String tiposervicio , @PathVariable ("idempleado") String idempleado) {
	      return   obj.SumaFichas(desde, hasta , empresa , tiposervicio , idempleado);
	    }
	
	
	@PostMapping("/servicio_detalles")
	public servicio_detalle insertar(@RequestBody servicio_detalle obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/servicio_detalles")
	public servicio_detalle actualizar(@RequestBody servicio_detalle obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/servicio_detalles/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}

}
