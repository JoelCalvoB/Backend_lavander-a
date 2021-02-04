package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.usuario;

public interface usuariosService {

	public List<usuario> getAll();
	public usuario get(Long id);
	public usuario insertar(usuario obj);
	public usuario actualizar(usuario obj);
	public Map<String,String> eliminar(Long id);
	
	
	public usuario ingresar(usuario obj)throws Throwable;
	public List<usuario> getAll(Long id_sucursal);

	public boolean getUsuarioPassword(Long id,String ps,String nuevo);
}
