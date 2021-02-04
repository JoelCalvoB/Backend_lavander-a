package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.proveedores;

public interface proveedoresService {
	public List<proveedores> getAll();
	public proveedores get(Long id);
	public proveedores insertar(proveedores obj);
	public proveedores actualizar(proveedores obj);
	public Map<String,String> eliminar(Long id);
}
