package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.productos;



public interface productosService {
	public List<productos> getAll();
	public productos get(Long id);
	public productos insertar(productos obj);
	public productos actualizar(productos obj);
	public Map<String,String> eliminar(Long id);
	public List<productos> getProductosPaginado(int pagina);
}
