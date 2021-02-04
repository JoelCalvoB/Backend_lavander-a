package com.entrecodigos.lavamax.models;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class clasificacion {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria")
	private List<productos> productos;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
    private sucursales sucursales;
	
	
	

	
	
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
	@JsonIgnoreProperties(value = "clasificacion")
	public List<productos> getProductos() {
		return productos;
	}
	public void setProductos(List<productos> productos) {
		this.productos = productos;
	}
	public sucursales getSucursales() {
		return sucursales;
	}
	public void setSucursales(sucursales sucursales) {
		this.sucursales = sucursales;
	}
	 
	
	
	
}
