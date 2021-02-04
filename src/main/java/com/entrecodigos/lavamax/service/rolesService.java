package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.menu;
import com.entrecodigos.lavamax.models.roles;

public interface rolesService {

	public List<roles> getAll();
	public roles get(Long id);
	public roles insertar(roles obj);
	public roles actualizar(roles obj);
	public Map<String,String> eliminar(Long id);
	public List<menu> obtenerMenus();
}
