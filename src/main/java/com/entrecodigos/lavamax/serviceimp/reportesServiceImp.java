package com.entrecodigos.lavamax.serviceimp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bea.xml.stream.samples.Parse;
import com.entrecodigos.lavamax.controllers.reportesController;
import com.entrecodigos.lavamax.service.reportesService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.repository.controlMovimientoRepository;


@Service
public class reportesServiceImp implements reportesService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 @Autowired
	  private ResourceLoader resourceLoader;
	 
	 
	 @Autowired
		private controlMovimientoRepository repositorio;


	@Override
	public Object reportePrueba() throws IOException, InterruptedException { 
		
		  Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            
	            InputStream is = resourceLoader.getResource("classpath:prueba1.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
		return null;
	}
	
	public Object reporteDetalleFichas(String desde, String hasta ,Integer empresa , Integer tiposervicio , Integer idempleado) throws IOException, InterruptedException { 
		 Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(desde);	  
	            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
	           

	            
	            parametros.put("desde",date1);
	            parametros.put("hasta",date2);
	            parametros.put("tipo_servicio" ,tiposervicio);
	            parametros.put("empleado", idempleado);
	            parametros.put("sucursal", empresa);


	            
	            InputStream is = resourceLoader.getResource("classpath:detallefichas.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	
	public Object reporteDetalleFichasSolo(String desde, String hasta ) throws IOException, InterruptedException { 
		 Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(desde);	  
	            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
	           	            
	            parametros.put("desde",date1);
	            parametros.put("hasta",date2);
 
	            InputStream is = resourceLoader.getResource("classpath:detallefichassolo.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	
	
	public Object reporteDetalleNoserv(String desde, String hasta ,Integer empresa , Integer idempleado) throws IOException, InterruptedException { 
		 Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(desde);	  
	            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
	           

	            
	            parametros.put("desde",date1);
	            parametros.put("hasta",date2);
	            parametros.put("empleado", idempleado);
	            parametros.put("sucursal", empresa);


	            
	            InputStream is = resourceLoader.getResource("classpath:detalleNoserv.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	public Object reporteDetalleFichasNosucur(String desde, String hasta , Integer tiposervicio , Integer idempleado) throws IOException, InterruptedException { 
		 Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(desde);	  
	            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
	           

	            
	            parametros.put("desde",date1);
	            parametros.put("hasta",date2);
	            parametros.put("tipo_servicio" ,tiposervicio);
	            parametros.put("empleado", idempleado);


	            
	            InputStream is = resourceLoader.getResource("classpath:detallefichasnosucur.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	
	
	
	public Object reporteDetalleFichasTodos(String desde, String hasta ) throws IOException, InterruptedException { 
		 Connection conn = null;
	        try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
	            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(desde);	  
	            Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(hasta);
	           

	            
	            parametros.put("desde",date1);
	            parametros.put("hasta",date2);
	          


	            
	            InputStream is = resourceLoader.getResource("classpath:todos.jasper").getInputStream();

	            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

	            
	            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
	            

	            conn.close();
	            Thread.sleep(3000);
	            
	            return print;
	        } catch (JRException ex) {
	            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	
	
	
	
	
	public Object reporteCorte(Integer id_sucursal , Integer id_usuario ) throws IOException, InterruptedException
	{
		controlMovimiento control = new controlMovimiento();
    	control.setId_sucursal(id_sucursal);
    	control.setId_usuario(id_usuario);
    	control.setTipo_mov("C");
    	Date fecha = new Date();
    	java.util.Date fec= new java.util.Date(fecha.getDay() , fecha.getMonth() , fecha.getYear());
    	control.setFecha(fec);
    	
    	repositorio.save(control);
		
		String query ="SELECT id_control , fecha FROM control_movimiento where tipo_mov='C' and id_sucursal =%1$s ORDER BY id_control desc limit 2;";
		query = String.format(query , id_sucursal);
	    List<Map<String, Object>> resultado = jdbcTemplate.queryForList(query);
	    String s2= String.valueOf(resultado.get(1).get("id_control")).toString();
	    String s1= String.valueOf(resultado.get(0).get("id_control")).toString();
	    
	    String f2= String.valueOf(resultado.get(1).get("fecha")).toString();
	    String f1= String.valueOf(resultado.get(0).get("fecha")).toString();
	    
	   Integer id1= Integer.parseInt(s1);
	   Integer id2= Integer.parseInt(s2);

	  
	    
		 Connection conn = null;

	      try {
	            conn = this.jdbcTemplate.getDataSource().getConnection();
	            Map<String,Object> parametros = new HashMap<String,Object>();
            
	            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(f1);
		        Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(f2);
	        
	        parametros.put("desde",id2);
            parametros.put("hasta",id1);
            parametros.put("f1",date1);
            parametros.put("f2",date2);
            parametros.put("id_sucursal" ,id_sucursal);


            
            InputStream is = resourceLoader.getResource("classpath:corte.jasper").getInputStream();

            JasperReport jasper = (JasperReport) JRLoader.loadObject(is);

            
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conn);
            

            conn.close();
            Thread.sleep(3000);
            
            return print;
        } catch (JRException ex) {
            Logger.getLogger(reportesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reportesServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return null;
}


	
}
