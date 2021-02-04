package com.entrecodigos.lavamax.serviceimp;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.cliente;
import com.entrecodigos.lavamax.models.servicio;
import com.entrecodigos.lavamax.repository.servicioRepository;
import com.entrecodigos.lavamax.repository.servicio_detalleRepository;
import com.entrecodigos.lavamax.models.servicio_detalle;
import com.entrecodigos.lavamax.service.servicioService;


@Service
public class servicioServiceImp implements servicioService{

	
	@Autowired
	private servicioRepository repositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private servicio_detalleRepository repoDetalle;
	
	
	@Override
	public List<servicio> getAll() {
		List<servicio> servicio = new ArrayList<servicio>();
		 this.repositorio.findAll().forEach(servicio::add);
		return servicio;
	}

	@Override
	public servicio get(Long id) {
		Optional<servicio> optcliente = this.repositorio.findById(id);
		if(optcliente.isPresent()) {
			return optcliente.get();
		}else {
			return null;
		}
	}

	@Override
	public servicio insertar(servicio obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public servicio actualizar(servicio obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);
		Map<String,String> resultado = new HashMap<String,String>();
		resultado.put("resultado", "Registro eliminado con exito");
		return resultado;
	}

	@Override
	public List<servicio> getTicketsCobrados(boolean cobrados) {
		// TODO Auto-generated method stub
		List<servicio> servicios = this.repositorio.findByTicketCobrado(cobrados);
		return servicios;
	}

	
	@Override
	public List<servicio_detalle> setdetalleServicio(List<servicio_detalle> detalle) {
		List<servicio_detalle> detallelista = new ArrayList<servicio_detalle>();
		this.repoDetalle.saveAll(detalle).forEach(detallelista::add);
		return detallelista;
	}

	@Override
	public List<servicio_detalle> getServicioDetalle(Long id_servicio) {
		List<servicio_detalle> detallelista = new ArrayList<servicio_detalle>();
		this.repoDetalle.findByIdservicio(id_servicio).forEach(detallelista::add);
		return detallelista;
		}

	@Override
	public void eliminardetalleServicio(Long id_detalle) {
	
		this.repoDetalle.deleteById(id_detalle);
		
	}

	@Override
	public List<servicio> getTicketsCobradosFecha(boolean cobrados, Date fecha) {
       
		List<servicio> servicios = new ArrayList<servicio>();
		
		this.repositorio.finbyticketCobradoFecha(cobrados, fecha).forEach(servicios::add);
		
		return servicios;
	}
	
	
	
	
	

}
