package com.entrecodigos.lavamax.serviceimp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.repository.controlMovimientoRepository;
import com.entrecodigos.lavamax.repository.productosRepository;
import com.entrecodigos.lavamax.repository.controlMovimientoRepository;
import com.entrecodigos.lavamax.service.controlMovimientoService;
import com.entrecodigos.lavamax.service.productosService;
import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.models.controlMovimiento;

@Service
public class controlMovimientosServiceImp  implements controlMovimientoService{

	@Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
	private controlMovimientoRepository repositorio;



	@Override
	public controlMovimiento get(Long id) {
		Optional<controlMovimiento> optcontrolMovimiento = this.repositorio.findById(id);
		if(optcontrolMovimiento.isPresent()) {
			return optcontrolMovimiento.get();
		}else {
			return null;
		}
	}

	@Override
	public controlMovimiento insertar(controlMovimiento obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public controlMovimiento actualizar(controlMovimiento obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public void insertarlista(List<controlMovimiento> obj) {

		
		
		
		repositorio.saveAll(obj);
	}

	public Object CorteInv(Integer sucursal, Integer id_usuario) {
		
		String query = "SELECT * FROM control_movimiento where tipo_mov='C' and id_sucursal=%1$s";
		query= String.format(query ,sucursal );
        List<Map<String, Object>> resultado = jdbcTemplate.queryForList(query);
        if (resultado.isEmpty())
        {
        
        	java.util.Date fecha = new java.util.Date();
        	controlMovimiento control = new controlMovimiento();
        	control.setId_sucursal(sucursal);
        	control.setId_usuario(id_usuario);
        	control.setTipo_mov("C");
        	java.util.Date fec= new java.util.Date(fecha.getDay() , fecha.getMonth() , fecha.getYear());
        	control.setFecha(fec);
        	
        	repositorio.save(control);
        	
        }
        
          
        

        return null;
	}
	
	
public controlMovimiento CorteXsucursal (controlMovimiento obj) {
	
	String query ="SELECT id_control FROM control_movimiento where tipo_mov='C' and id_sucursal =%1$s ORDER BY id_control desc limit 2;";
	query = String.format(query , obj.getId_sucursal());
    List<Map<String, Object>> resultado = jdbcTemplate.queryForList(query);
    String fecha2= resultado.get(0).toString();
    String fecha1= resultado.get(1).toString();
    


	return null;
	
}
	
	
	



}
