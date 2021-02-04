package com.entrecodigos.lavamax.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idservicio;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long noservicio;
	private Long idempleado;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
    private cliente cliente;
	private Date fecha;
	@Column(name = "tipo_servicio")
	private Long tipoServicio;
	private String observaciones;
	private String opcontrato;
	private String diagnostico;
	@Column(name = "total_refacciones")
	private Long totalRefacciones;
	private String nombretmp;
	private String direcciontmp;
	private String telefonotmp;
	private String tc;
	@Column(name = "orden_impresa")
	private boolean ordenImpresa;
	@Column(name = "orden_pagada")
	private boolean ordenPagada;
	@Column(name = "orden_terminada")
	private boolean ordenTerminada;
	@Column(name = "fecha_terminado")
	private Date fechaterminado;
	private Long idVenta;
	private Long idsucursal;
	private double descuento;
	private double recibe;
	private Long idTipoProducto;
	private boolean mciva;
	private double total_recepcion;
	private String hora;
	@Column(name = "fecha_entrega")
	private Date fechaentrega;
	@Column(name = "totales_costo")
	private double totalescosto;
	private double subtotales;
	private double iva;
	@Column(name = "horaentrega")
	private String hora_entrega;
	private boolean entregado;
	private Long turno;
	@Column(name = "tmp_nombrecliente")
	private String nombreClienteTemp;
	@Column(name = "tmp_direccioncliente")
	private String direccionClienteTemp;
	private double importeTotal;
	private boolean cancelado;

	@OneToMany(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
	@OrderBy
	private List<servicio_detalle> detalleServicio;

	public List<servicio_detalle> getDetalleServicio() {
		return detalleServicio;
	}

	public void setDetalleServicio(List<servicio_detalle> detalleServicio) {
		this.detalleServicio = detalleServicio;
	}

	public Long getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(Long idservicio) {
		this.idservicio = idservicio;
	}

	public Long getNoservicio() {
		return noservicio;
	}

	public void setNoservicio(Long noservicio) {
		this.noservicio = noservicio;
	}

	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public void setIdsucursal(Long idsucursal) {
		this.idsucursal = idsucursal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Long tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOpcontrato() {
		return opcontrato;
	}

	public void setOpcontrato(String opcontrato) {
		this.opcontrato = opcontrato;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Long getTotalRefacciones() {
		return totalRefacciones;
	}

	public void setTotalRefacciones(Long totalRefacciones) {
		this.totalRefacciones = totalRefacciones;
	}

	public String getNombretmp() {
		return nombretmp;
	}

	public void setNombretmp(String nombretmp) {
		this.nombretmp = nombretmp;
	}

	public String getDirecciontmp() {
		return direcciontmp;
	}

	public void setDirecciontmp(String direcciontmp) {
		this.direcciontmp = direcciontmp;
	}

	public String getTelefonotmp() {
		return telefonotmp;
	}

	public void setTelefonotmp(String telefonotmp) {
		this.telefonotmp = telefonotmp;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public boolean isOrdenImpresa() {
		return ordenImpresa;
	}

	public void setOrdenImpresa(boolean ordenImpresa) {
		this.ordenImpresa = ordenImpresa;
	}

	public boolean isOrdenPagada() {
		return ordenPagada;
	}

	public void setOrdenPagada(boolean ordenPagada) {
		this.ordenPagada = ordenPagada;
	}

	public boolean isOrdenTerminada() {
		return ordenTerminada;
	}

	public void setOrdenTerminada(boolean ordenTerminada) {
		this.ordenTerminada = ordenTerminada;
	}

	public Date getFechaterminado() {
		return fechaterminado;
	}

	public void setFechaterminado(Date fechaterminado) {
		this.fechaterminado = fechaterminado;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Long getIdsucursal() {
		return idsucursal;
	}
	public void setIdempresa(Long idsucursal) {
		this.idsucursal = idsucursal;
	}


	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getRecibe() {
		return recibe;
	}

	public void setRecibe(double recibe) {
		this.recibe = recibe;
	}

	public Long getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public boolean isMciva() {
		return mciva;
	}

	public void setMciva(boolean mciva) {
		this.mciva = mciva;
	}

	public double getTotal_recepcion() {
		return total_recepcion;
	}

	public void setTotal_recepcion(double total_recepcion) {
		this.total_recepcion = total_recepcion;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public double getTotalescosto() {
		return totalescosto;
	}

	public void setTotalescosto(double totalescosto) {
		this.totalescosto = totalescosto;
	}

	public double getSubtotales() {
		return subtotales;
	}

	public void setSubtotales(double subtotales) {
		this.subtotales = subtotales;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public String getHora_entrega() {
		return hora_entrega;
	}

	public void setHora_entrega(String hora_entrega) {
		this.hora_entrega = hora_entrega;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Long getTurno() {
		return turno;
	}

	public void setTurno(Long turno) {
		this.turno = turno;
	}

	public String getNombreClienteTemp() {
		return nombreClienteTemp;
	}

	public void setNombreClienteTemp(String nombreClienteTemp) {
		this.nombreClienteTemp = nombreClienteTemp;
	}

	public String getDireccionClienteTemp() {
		return direccionClienteTemp;
	}

	public void setDireccionClienteTemp(String direccionClienteTemp) {
		this.direccionClienteTemp = direccionClienteTemp;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	
}