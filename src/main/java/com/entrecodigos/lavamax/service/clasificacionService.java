package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.clasificacion;

public interface clasificacionService {
	public List<clasificacion> getAll();
	public clasificacion get(Long id);
	public clasificacion insertar(clasificacion obj);
	public clasificacion actualizar(clasificacion obj);
	public Map<String,String> eliminar(Long id);
	public List<clasificacion> getClasificacionPaginado(int pagina);
}
