package com.entrecodigos.lavamax.service;

import java.io.IOException;

import com.entrecodigos.lavamax.models.controlMovimiento;
import com.sun.el.parser.ParseException;

public interface reportesService {

	public Object reportePrueba()throws IOException, InterruptedException ;
	public Object reporteDetalleFichas(String desde, String hasta ,Integer empresa , Integer tiposervicio , Integer idempleado )throws IOException, InterruptedException ;
	public Object reporteDetalleFichasSolo(String desde, String hasta )throws IOException, InterruptedException ;
	public Object reporteDetalleNoserv(String desde, String hasta ,Integer empresa , Integer idempleado )throws IOException, InterruptedException ;
	public Object reporteDetalleFichasTodos(String desde, String hasta  )throws IOException, InterruptedException ;
	public Object reporteDetalleFichasNosucur(String desde, String hasta , Integer tiposervicio , Integer idempleado )throws IOException, InterruptedException ;
public Object reporteCorte ( Integer id_sucursal ,Integer id_usuario)throws IOException, InterruptedException ;

}
