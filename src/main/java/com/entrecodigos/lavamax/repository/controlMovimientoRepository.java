package com.entrecodigos.lavamax.repository;
import org.springframework.data.repository.CrudRepository;

import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.models.proveedores;


public interface controlMovimientoRepository  extends CrudRepository<controlMovimiento, Long> {
	

}
