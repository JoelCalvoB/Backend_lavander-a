package com.entrecodigos.lavamax.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.entrecodigos.lavamax.models.servicio;
import com.entrecodigos.lavamax.models.servicio_detalle;
import com.entrecodigos.lavamax.service.servicioService;

@RestController
@RequestMapping("/api")
public class servicioController {

	@Autowired
	private servicioService obj;
	
	
	@GetMapping("/servicios")
	public List<servicio> getAll(){
		return this.obj.getAll();
	}
	
	@GetMapping("/servicios/{identificador}")
	public servicio get(@PathVariable("identificador") Long id) {
		return this.obj.get(id);
	}
	
	
	@PostMapping("/servicios")
	public servicio insertar(@RequestBody servicio obj) {
		return this.obj.insertar(obj);
	}
	
	@PutMapping("/servicios")
	public servicio actualizar(@RequestBody servicio obj) {
		return this.obj.actualizar(obj);
	}
	
	@DeleteMapping("/servicios/{identificador}")
	public Map<String,String> eliminar(@PathVariable("identificador") Long id){
		return this.obj.eliminar(id);
	}
	
	
	@PostMapping("/servicios/ventas")
	public servicio realizarVenta(@RequestBody servicio obj) {
		return this.obj.insertar(obj);
	}
	
	@GetMapping("/servicios/ventas")
	public List<servicio> getTicketsCobrados(@RequestParam("cobrado") boolean cobrado){
		return this.obj.getTicketsCobrados(cobrado);
	}
	
	@PostMapping("/servicios/ventas/detalleservicio")
	public List<servicio_detalle> setdetalleServicio(@RequestBody List<servicio_detalle> detalle){
		return this.obj.setdetalleServicio(detalle);
	}
	@GetMapping("/servicios/ventas/detalleservicio/{id_servicio}")
	public List<servicio_detalle> setdetalleServicio(@PathVariable("id_servicio") Long id_servicio){
		return this.obj.getServicioDetalle(id_servicio);
	}
	
	@DeleteMapping("/servicios/ventas/detalleservicio/{id_registro}")
	public void eliminarDetalleItem(@PathVariable("id_registro") Long id_detalle){
		this.obj.eliminardetalleServicio(id_detalle);
	}
	
	
	@GetMapping("/servicios/ventas/cobrados")
	public List<servicio> getServiciocobradoFecha(@RequestParam("cobrado")boolean cobrado,@RequestParam("fecha")String fecha) throws ParseException{
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		return this.obj.getTicketsCobradosFecha(cobrado, date1);
	}
}
