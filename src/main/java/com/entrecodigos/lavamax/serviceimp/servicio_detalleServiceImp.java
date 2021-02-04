package com.entrecodigos.lavamax.serviceimp;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.servicio_detalle;
import com.entrecodigos.lavamax.models.servicio_detalle;
import com.entrecodigos.lavamax.repository.servicio_detalleRepository;
import com.entrecodigos.lavamax.service.servicio_detalleService;
import com.zaxxer.hikari.util.SuspendResumeLock;

@Service
public class servicio_detalleServiceImp implements servicio_detalleService{
	
	@Autowired
	private servicio_detalleRepository repositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<servicio_detalle> getAll() {
		List<servicio_detalle> servicio_detalle = new ArrayList<servicio_detalle>();
		 this.repositorio.findAll().forEach(servicio_detalle::add);
		return servicio_detalle;
	}

	@Override
	public servicio_detalle get(Long id) {
		Optional<servicio_detalle> optservicio_detalle = this.repositorio.findById(id);
		if(optservicio_detalle.isPresent()) {
			return optservicio_detalle.get();
		}else {
			return null;
		}
	}

	@Override
	public servicio_detalle insertar(servicio_detalle obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public servicio_detalle actualizar(servicio_detalle obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);
		Map<String,String> resultado = new HashMap<String,String>();
		resultado.put("resultado", "Registro eliminado con exito");
		return resultado;
	}

			
	
	
public Object traeDetalleFichas(String desde, String  hasta ,String empresa ,String tiposervicio ,String idempleado ) {
	
	
	String sucursal ;
	if (empresa.contains("0"))
	{
		sucursal="";
				
	}
	else
	{
		sucursal ="and idsucursal = " + empresa;
	}
	
	String empleado;
	
	if (idempleado.contains("0"))
	{
		empleado ="";
	}
	else
		
	{
		empleado = "and a1.idempleado =" + idempleado;
	}
	
	
	String servicio;
	if (tiposervicio.contains("0"))
	{
		servicio ="";
	}
	else
		
	{
		servicio=" and tipo_servicio = " + tiposervicio;
	}
		
		String query = "SELECT	a1.idservicio,a1.totales_costo as total ,	a1.noservicio,	a1.fecha,a1.tipo_servicio as tiposerv, a2.nombre as nombrecliente, a4.nombre as empleado,COALESCE( sum (a3.cantficha) FILTER(where a3.idficha='1'), NULL , 0) as ficha4kg,  COALESCE (sum (a3.cantficha) FILTER(where a3.idficha='2'), NULL , 0) as ficha8kg, COALESCE (sum (a3.cantficha) FILTER(where a3.idficha='3' ), NULL , 0) as fichasecadora\r\n" + 
				"FROM servicio a1  left JOIN clientes a2 ON a1.id_cliente =a2.id_cliente INNER JOIN servicio_detalle a3 on a1.idservicio =a3.idservicio  INNER JOIN usuarios a4 ON a1.idempleado=a4.id\r\n" + 
				" where a1.fecha BETWEEN '%1$s' and '%2$s'\r\n" + 
				" %3$s   %4$s  %5$s GROUP BY a1.idservicio, a1.noservicio, a1.fecha,a1.tipo_servicio,a2.nombre , a4.nombre";
		
				
		query= String.format(query , desde, hasta, servicio , sucursal , empleado);
		
		List<Map<String,Object>> resultado = this.jdbcTemplate.queryForList(query);
		
		return resultado;
	}



public Object SumaFichas( String desde, String  hasta ,String empresa ,String tiposervicio ,String idempleado)
{
	
	String sucursal ;
	if (empresa.contains("0"))
	{
		sucursal="";
				
	}
	else
	{
		sucursal ="and idsucursal = " + empresa;
	}
	
	String empleado;
	
	if (idempleado.contains("0"))
	{
		empleado ="";
	}
	else
		
	{
		empleado = "and idempleado =" + idempleado;
	}
	
	
	String servicio;
	if (tiposervicio.contains("0"))
	{
		servicio ="";
	}
	else
		
	{
		servicio=" and tipo_servicio = " + tiposervicio;
	}
	
	
	String suma ="SELECT( SELECT COUNT (*) as Totalserv FROM servicio   a1                                                                  WHERE a1.fecha BETWEEN '%1$s' AND '%2$s'  %3$S %4$s %5$s  ) AS Totalserv,	(SELECT SUM (cantficha) FROM servicio_detalle a1\r\n" + 
			"INNER JOIN servicio a2 ON a1.idservicio = a2.idservicio	                                                     	WHERE a1.fecha BETWEEN '%1$s' AND '%2$s'  AND idficha = 1  %3$S %4$s %5$s ) AS ficha4kg,\r\n" + 
			"(SELECT		SUM (cantficha) FROM servicio_detalle a1 INNER JOIN servicio a2 ON a1.idservicio = a2.idservicio    WHERE a1.fecha BETWEEN '%1$s' AND '%2$s'  AND idficha = 2  %3$S %4$s %5$s ) AS ficha8kg,\r\n" + 
			"	(SELECT SUM (cantficha)	FROM	servicio_detalle a1	INNER JOIN servicio a2 ON a1.idservicio = a2.idservicio	     WHERE a1.fecha BETWEEN '%1$s' AND '%2$s' AND idficha = 3  %3$S %4$s %5$s ) AS secadora\r\n" + 
			"FROM servicio_detalle LIMIT 1";
	suma=String.format(suma , desde , hasta , sucursal , servicio , empleado);
		
	List<Map<String,Object>> resultado = this.jdbcTemplate.queryForList(suma);
	return resultado;


}
	
	

}
