package com.entrecodigos.lavamax.service;



import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.servicio_detalle;

public interface servicio_detalleService {
	
	public List<servicio_detalle> getAll();
	public servicio_detalle get(Long id);
	public servicio_detalle insertar(servicio_detalle obj);
	public servicio_detalle actualizar(servicio_detalle obj);
	public Map<String,String> eliminar(Long id);
	public Object traeDetalleFichas(String desde, String hasta ,String empresa , String tiposervicio , String idempleado);
	public Object SumaFichas(String desde, String hasta ,String empresa , String tiposervicio , String idempleado);

}
