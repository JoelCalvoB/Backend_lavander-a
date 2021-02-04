package com.entrecodigos.lavamax.models;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class menu {
	@Id
	private Long id;
	private String nombreMenu;
	private boolean activo;
	
	
 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
	

}
