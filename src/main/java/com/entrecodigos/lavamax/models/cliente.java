package com.entrecodigos.lavamax.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class cliente {
  
	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellido;
	private String rfc;
	private String direccion;
	private String ciudad;
	private String estado;
	@Column(name = "codigo_postal")
	private String codigopostal;
	private String pais;
	private String telefono;
	private String observaciones;
	@Column(name="f_alta")
	private Date fechalta;
	
	private boolean credito;
	@Column(name="credito_vencido")
	private boolean creditoVencido;
	@Column(name="otorga_credito")
	private boolean otorgarCredito;
	@Column(name="tipo_credito")
	private Long tipoCredito;
	private Long dias;
	private double descuento;
	@Column(name="poliza_servicio")
	private boolean clientePolizaserv;
	@Column(name="limite_credito")
	private double limiteCredito;
	private double saldo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechalta() {
		return fechalta;
	}
	public void setFechalta(Date fechalta) {
		this.fechalta = fechalta;
	}
	public boolean isCredito() {
		return credito;
	}
	public void setCredito(boolean credito) {
		this.credito = credito;
	}
	public boolean isCreditoVencido() {
		return creditoVencido;
	}
	public void setCreditoVencido(boolean creditoVencido) {
		this.creditoVencido = creditoVencido;
	}
	public boolean isOtorgarCredito() {
		return otorgarCredito;
	}
	public void setOtorgarCredito(boolean otorgarCredito) {
		this.otorgarCredito = otorgarCredito;
	}
	public Long getTipoCredito() {
		return tipoCredito;
	}
	public void setTipoCredito(Long tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	public Long getDias() {
		return dias;
	}
	public void setDias(Long dias) {
		this.dias = dias;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public boolean isClientePolizaserv() {
		return clientePolizaserv;
	}
	public void setClientePolizaserv(boolean clientePolizaserv) {
		this.clientePolizaserv = clientePolizaserv;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
