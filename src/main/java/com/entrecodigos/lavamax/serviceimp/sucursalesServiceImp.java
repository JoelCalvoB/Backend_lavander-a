package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.repository.sucursalesRepository;
import com.entrecodigos.lavamax.service.sucursalesService;

@Service
public class sucursalesServiceImp implements sucursalesService{

	@Autowired
	private sucursalesRepository repositorio;
	
	@Override
	public List<sucursales> getAll() {
		List<sucursales> sucursales = new ArrayList<sucursales>();
		 this.repositorio.findAll().forEach(sucursales::add);
		return sucursales;
	}

	@Override
	public sucursales get(Long id) {
		Optional<sucursales> optSucursales = this.repositorio.findById(id);
		if(optSucursales.isPresent()) {
			return optSucursales.get();
		}else {
			return null;
		}
	}

	@Override
	public sucursales insertar(sucursales obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public sucursales actualizar(sucursales obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);
		Map<String,String> resultado = new HashMap<String,String>();
		resultado.put("resultado", "Registro eliminado con exito");
		return resultado;
	}

	
	
	
}
