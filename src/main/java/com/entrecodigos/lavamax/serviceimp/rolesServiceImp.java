package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.menu;
import com.entrecodigos.lavamax.models.roles;
import com.entrecodigos.lavamax.repository.menuRepository;
import com.entrecodigos.lavamax.repository.rolesRepository;
import com.entrecodigos.lavamax.service.rolesService;

@Service
public class rolesServiceImp implements rolesService{

	@Autowired
	private rolesRepository repositorio;
	
	@Autowired
	private menuRepository repoMenu;
	
	
	@Override
	public List<roles> getAll() {
		List<roles> roles = new ArrayList<roles>();
		 this.repositorio.findAll().forEach(roles::add);
		return roles;
	}

	@Override
	public roles get(Long id) {
		Optional<roles> optroles = this.repositorio.findById(id);
		if(optroles.isPresent()) {
			return optroles.get();
		}else {
			return null;
		}
	}

	@Override
	public roles insertar(roles obj) {
		List<menu> menu = obj.getListaMenu();
		obj.setListaMenu(null);
		roles rol = repositorio.save(obj);
		rol.setListaMenu(menu);
		return repositorio.save(rol);
	}

	@Override
	public roles actualizar(roles obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);
		Map<String,String> resultado = new HashMap<String,String>();
		resultado.put("resultado", "Registro eliminado con exito");
		return resultado;
	}

	@Override
	public List<menu> obtenerMenus() {
		List<menu> listaMenus = new ArrayList<menu>();
		this.repoMenu.findAll().forEach(listaMenus::add);
		return listaMenus;
	}

}
