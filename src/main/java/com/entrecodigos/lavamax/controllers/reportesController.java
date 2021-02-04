package com.entrecodigos.lavamax.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrecodigos.lavamax.models.controlMovimiento;
import com.entrecodigos.lavamax.service.reportesService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/reportes")
public class reportesController {

	@Autowired
	private reportesService obj;
	
	
	@GetMapping("/prueba")
	public Object pruebaReporte() throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reportePrueba();
	        byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"reporte.pdf\"")
	                .body(bytes);
	}
	
	
	 @GetMapping("/servicio/{desde}/{hasta}/{empresa}/{tiposervicio}/{idempleado}/pdf")
	 public Object reporteDetalleFichas(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta,@PathVariable("empresa")Integer empresa , @PathVariable ("tiposervicio") Integer tiposervicio , @PathVariable ("idempleado") Integer idempleado)throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reporteDetalleFichas(desde, hasta, empresa, tiposervicio, idempleado);
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"detallefichas.pdf\"")
	                .body(bytes);
	}
	 
	 
	 
	 @GetMapping("/servicio/solo/{desde}/{hasta}/pdf")
	 public Object reporteDetalleFichasSolo(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta,@PathVariable("empresa")Integer empresa , @PathVariable ("tiposervicio") Integer tiposervicio , @PathVariable ("idempleado") Integer idempleado)throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reporteDetalleFichas(desde, hasta, empresa, tiposervicio, idempleado);
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"detallefichas.pdf\"")
	                .body(bytes);
	}
	
	 
	 
	 @GetMapping("/servicio/noservicio/{desde}/{hasta}/{empresa}/{idempleado}/pdf")
	 public Object reporteDetalleNoserv(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta,@PathVariable("empresa")Integer empresa , @PathVariable ("idempleado") Integer idempleado)throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reporteDetalleNoserv(desde, hasta, empresa, idempleado);
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"detallefichas.pdf\"")
	                .body(bytes);
	}
	 
	 
@GetMapping("/servicio/todos/{desde}/{hasta}/pdf")
public Object reporteDetalleFichasTodos (@PathVariable("desde") String desde,@PathVariable("hasta") String hasta) throws IOException, InterruptedException, JRException {
	JasperPrint print = (JasperPrint) obj.reporteDetalleFichasTodos(desde, hasta);
	 byte[] bytes = JasperExportManager.exportReportToPdf(print);
     return ResponseEntity
             .ok()
             .header("Content-Type", "application/pdf; charset=UTF-8")
             .header("Content-Disposition", "inline; filename=\"" +"detallefichas.pdf\"")
             .body(bytes);
}
	 
	 
	 
	 
	 
	 
	 @GetMapping("/servicio/nosucursal/{desde}/{hasta}/{tiposervicio}/{idempleado}/pdf")
	 public Object reporteDetalleFichasNosucur(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta , @PathVariable ("tiposervicio") Integer tiposervicio , @PathVariable ("idempleado") Integer idempleado)throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reporteDetalleFichasNosucur(desde, hasta,  tiposervicio, idempleado);
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"detallefichas.pdf\"")
	                .body(bytes);
	}
	 
	 @GetMapping("/corte/{id_sucursal}/{id_usuario}/pdf")
	 public Object reporteCorte(@PathVariable ("id_sucursal")  Integer id_sucursal , Integer id_usuario)throws IOException, InterruptedException, JRException {
		 JasperPrint print = (JasperPrint) obj.reporteCorte (id_sucursal , id_usuario);
		 byte[] bytes = JasperExportManager.exportReportToPdf(print);
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "application/pdf; charset=UTF-8")
	                .header("Content-Disposition", "inline; filename=\"" +"corte.pdf\"")
	                .body(bytes);
	}
}
