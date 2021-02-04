package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.cliente;

public interface clientesService {
	public List<cliente> getAll();
	public cliente get(Long id);
	public cliente insertar(cliente obj);
	public cliente actualizar(cliente obj);
	public Map<String,String> eliminar(Long id);
	public List<cliente> getClientesPaginado(int pagina);
}
