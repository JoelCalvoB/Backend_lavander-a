package com.entrecodigos.lavamax.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class controlMovimiento {
	
	@Id
	@Column(name = "id_control")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_control;
	private Integer cantidad;
	private String tipo_mov;
	private Integer id_producto;
	private Integer id_sucursal;
	private Integer id_usuario;
	private Date fecha;
	private String hora;
	
	
	

	public Long getId_control() {
		return id_control;
	}
	public void setId_control(Long id_control) {
		this.id_control = id_control;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo_mov() {
		return tipo_mov;
	}
	public void setTipo_mov(String tipo_mov) {
		this.tipo_mov = tipo_mov;
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
