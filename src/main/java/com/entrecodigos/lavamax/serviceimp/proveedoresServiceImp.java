package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.proveedores;
import com.entrecodigos.lavamax.repository.proveedoresRepository;
import com.entrecodigos.lavamax.service.proveedoresService;

@Service
public class proveedoresServiceImp implements proveedoresService {
	@Autowired
	private proveedoresRepository repositorio;

	@Override
	public List<proveedores> getAll() {
		List<proveedores> proveedores = new ArrayList<proveedores>();
		 this.repositorio.findAll().forEach(proveedores::add);
		return proveedores;
	}

	@Override
	public proveedores get(Long id) {
		Optional<proveedores> optproveedores = this.repositorio.findById(id);
		if(optproveedores.isPresent()) {
			return optproveedores.get();
		}else {
			return null;
		}
	}

	@Override
	public proveedores insertar(proveedores obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public proveedores actualizar(proveedores obj) {
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
