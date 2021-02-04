package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.unidadesMedida;
import com.entrecodigos.lavamax.repository.unidadesMedidaRepository;
import com.entrecodigos.lavamax.service.unidadesMedidaService;

@Service
public class unidadesMedidaServiceImp  implements unidadesMedidaService{


	@Autowired
	private unidadesMedidaRepository repositorio;

	@Override
	public List<unidadesMedida> getAll() {
		List<unidadesMedida> sucursales = new ArrayList<unidadesMedida>();
		 this.repositorio.findAll().forEach(sucursales::add);
		return sucursales;
	}

	@Override
	public unidadesMedida get(Long id) {
		Optional<unidadesMedida> optunidadesMedida = this.repositorio.findById(id);
		if(optunidadesMedida.isPresent()) {
			return optunidadesMedida.get();
		}else {
			return null;
		}
	}

	@Override
	public unidadesMedida insertar(unidadesMedida obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public unidadesMedida actualizar(unidadesMedida obj) {
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
