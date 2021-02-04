package com.entrecodigos.lavamax.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	
	
	@ManyToMany
	@JoinTable(name = "detalle_roles",joinColumns = @JoinColumn(name = "id_rol",nullable = false),
	inverseJoinColumns = @JoinColumn(name="id_menu",nullable = false))
	private List<menu> listaMenu;

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

	public List<menu> getListaMenu() {
		return listaMenu;
	}

	public void setListaMenu(List<menu> listaMenu) {
		this.listaMenu = listaMenu;
	}
	
	
	
}
