package com.entrecodigos.lavamax.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.servicio;
import com.entrecodigos.lavamax.models.servicio_detalle;

public interface servicioService {
	public List<servicio> getAll();
	public servicio get(Long id);
	public servicio insertar(servicio obj);
	public servicio actualizar(servicio obj);
	public Map<String,String> eliminar(Long id);
	public List<servicio> getTicketsCobrados(boolean cobrados);
	public List<servicio_detalle> setdetalleServicio( List<servicio_detalle> detalle);
	public List<servicio_detalle> getServicioDetalle( Long id_servicio);
	public void eliminardetalleServicio(Long id_detalle);
	public List<servicio> getTicketsCobradosFecha(boolean cobrados,Date fecha);
}
