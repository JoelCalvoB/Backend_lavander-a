package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.models.proveedores;

public interface controlMovimientoService {
	
	public controlMovimiento get(Long id);
	public controlMovimiento insertar(controlMovimiento obj);
	public controlMovimiento actualizar(controlMovimiento obj);
 public void  insertarlista (List <controlMovimiento> obj);
 public Object CorteInv(Integer sucursal, Integer id_usuario) ;


}
