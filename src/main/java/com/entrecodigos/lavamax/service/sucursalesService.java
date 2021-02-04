package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.sucursales;

public interface sucursalesService {
	public List<sucursales> getAll();
	public sucursales get(Long id);
	public sucursales insertar(sucursales obj);
	public sucursales actualizar(sucursales obj);
	public Map<String,String> eliminar(Long id);
}
